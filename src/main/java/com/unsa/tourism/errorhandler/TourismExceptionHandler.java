package com.unsa.tourism.errorhandler;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.client.HttpStatusCodeException;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.unsa.tourism.constants.TourismConstants;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.util.ArrayList;
import java.util.List;

@ControllerAdvice
public class TourismExceptionHandler extends ResponseEntityExceptionHandler {
	private static final Logger logger = LogManager.getLogger(TourismExceptionHandler.class);
    @ExceptionHandler(HttpStatusCodeException.class)
    protected ResponseEntity<Object> handleHttpRestClient(HttpStatusCodeException ex){
        TourismError reloanError = null;
        if(ex.getStatusCode().is4xxClientError()){
            reloanError = new TourismError(ex.getStatusCode(),
            		TourismConstants.PREFIX_CLIENT_ERROR);
        }else if(ex.getStatusCode().is5xxServerError()){
            reloanError = new TourismError(ex.getStatusCode(),
            		TourismConstants.PREFIX_SERVER_ERROR);
        }
        reloanError.setMessage(ex.getStatusText());
		logger.error("Error realizando peticion HTTP", ex);
        return buildResponseEntity(reloanError);
    }


    @ExceptionHandler(TourismEntityNotFoundException.class)
    protected ResponseEntity<Object> handleEntityNotFound(TourismEntityNotFoundException ex) {
        TourismError reloanError = new TourismError(HttpStatus.NOT_FOUND,
        		TourismConstants.PREFIX_CLIENT_ERROR + TourismConstants.NOT_FOUND);
        reloanError.setMessage(ex.getMessage());
        //new 6
        if(ex.getLogger()!=null) ex.getLogger().error(ex.getMessage(), ex);
        return buildResponseEntity(reloanError);
    }


    @ExceptionHandler(TourismConflictException.class)
    protected ResponseEntity<Object> handleConflict(TourismConflictException ex) {
        TourismError reloanError = new TourismError(HttpStatus.CONFLICT,
        		TourismConstants.PREFIX_CLIENT_ERROR + TourismConstants.CONFLICT);
        reloanError.setMessage(ex.getMessage());
       if(ex.getLogger()!=null) ex.getLogger().error(ex.getMessage(), ex);
        return buildResponseEntity(reloanError);
    }

    @ExceptionHandler(TourismUnauthorizedException.class)
    protected ResponseEntity<Object> handleConflict(TourismUnauthorizedException ex) {
        TourismError reloanError = new TourismError(HttpStatus.UNAUTHORIZED,
        		TourismConstants.PREFIX_CLIENT_ERROR + TourismConstants.UNAUTHORIZED);
        reloanError.setMessage(ex.getMessage());
        if(ex.getLogger()!=null) ex.getLogger().error(ex.getMessage(), ex);
        return buildResponseEntity(reloanError);
    }


    @ExceptionHandler(TourismGenericServerException.class)
    protected ResponseEntity<Object> handleGenericServerError(TourismGenericServerException ex) {
        TourismError reloanError = null;
        if(ex.getCode()!=null){
            reloanError = new TourismError(HttpStatus.INTERNAL_SERVER_ERROR, ex.getCode());
        }else{
            reloanError = new TourismError(HttpStatus.INTERNAL_SERVER_ERROR,
                    TourismConstants.PREFIX_SERVER_ERROR + TourismConstants.INTERNAL_SERVER_ERROR);
        }
        reloanError.setMessage(ex.getMessage());
        //new 6
        if(ex.getLogger()!=null) ex.getLogger().error(ex.getMessage(), ex);
        return buildResponseEntity(reloanError);
    }

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
                                                                  HttpHeaders headers, HttpStatus status,
                                                                  WebRequest request) {
        TourismError reloanError = new TourismError(HttpStatus.BAD_REQUEST,
                TourismConstants.PREFIX_CLIENT_ERROR + TourismConstants.BAD_REQUEST);
        reloanError.setMessage(ex.getBindingResult().getFieldError().toString());
        reloanError.setSubErrors(fillValidationErrorsFrom(ex));
        //new spring 6
		logger.error("Error validando peticion", ex);
        return buildResponseEntity(reloanError);
    }

    @ExceptionHandler(TourismGenericClientException.class)
    protected ResponseEntity<Object> handleGenericClientException(TourismGenericClientException ex) {
        TourismError reloanError = new TourismError(ex.getHttpStatus(),
                TourismConstants.PREFIX_CLIENT_ERROR);
        reloanError.setMessage(ex.getMessage());
        reloanError.setSubErrors(ex.getSubErrors());
        //new spring 6
        if(ex.getLogger()!=null) ex.getLogger().error(ex.getMessage(), ex);
        return buildResponseEntity(reloanError);

    }

    @ExceptionHandler(Exception.class)
    protected ResponseEntity<Object> handleError(Exception ex) {
        TourismError reloanError = new TourismError(HttpStatus.INTERNAL_SERVER_ERROR,
                TourismConstants.PREFIX_SERVER_ERROR + TourismConstants.INTERNAL_SERVER_ERROR);
        reloanError.setMessage("Error generico de servidor " + ex.getMessage());
        return buildResponseEntity(reloanError);
    }

    @Override
    protected ResponseEntity<Object> handleHttpMessageNotReadable(HttpMessageNotReadableException ex,
                                                                  HttpHeaders headers, HttpStatus status,
                                                                  WebRequest request) {
        String error = "Malformed JSON request";
        return buildResponseEntity(new TourismError(HttpStatus.BAD_REQUEST,
                TourismConstants.PREFIX_CLIENT_ERROR + TourismConstants.BAD_REQUEST, error, ex));
    }

    @Override
    protected ResponseEntity<Object> handleMissingServletRequestParameter(MissingServletRequestParameterException ex,
                                                                          HttpHeaders headers, HttpStatus status,
                                                                          WebRequest request) {
        String error = ex.getParameterName() + " parameter is missing";

        return buildResponseEntity(new TourismError(HttpStatus.BAD_REQUEST,
                TourismConstants.PREFIX_CLIENT_ERROR + TourismConstants.BAD_REQUEST, error, ex));
    }

    private ResponseEntity<Object> buildResponseEntity(TourismError reloanError) {
        return new ResponseEntity<>(reloanError, reloanError.getHttpStatus());
    }

    protected List<TourismSubError> fillValidationErrorsFrom(MethodArgumentNotValidException argumentNotValid) {
        List<TourismSubError> subErrorCollection = new ArrayList<>();
        argumentNotValid.getBindingResult().getFieldErrors().get(0).getRejectedValue();
        argumentNotValid.getBindingResult().getFieldErrors().stream().forEach((objError) -> {
            TourismSubError reloanSubError = new TourismValidationError(objError.getObjectName(),
                    objError.getField(), objError.getRejectedValue(), objError.getDefaultMessage());
            subErrorCollection.add(reloanSubError);
        });
        return subErrorCollection;
    }
}
