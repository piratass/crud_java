package com.unsa.tourism.errorhandler.rest;

import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.web.client.ResponseErrorHandler;

import com.unsa.tourism.errorhandler.TourismGenericClientException;
import com.unsa.tourism.errorhandler.TourismGenericServerException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.io.IOException;
import java.net.URI;

import static org.springframework.http.HttpStatus.Series.CLIENT_ERROR;
import static org.springframework.http.HttpStatus.Series.SERVER_ERROR;

public class RestErrorHandler implements ResponseErrorHandler {

	public final static Logger logger= LogManager.getLogger(RestErrorHandler.class);
    @Override
    public boolean hasError(ClientHttpResponse response) throws IOException {
        return (
                response.getStatusCode().series() == CLIENT_ERROR
                        || response.getStatusCode().series() == SERVER_ERROR);
    }

    @Override
    public void handleError(URI url, HttpMethod method, ClientHttpResponse response) throws IOException {
        if(response.getStatusCode().series() == HttpStatus.Series.SERVER_ERROR){
        	logger.error("Internal server error on provider site path: "+url.getPath());
            throw new TourismGenericServerException("Internal server error on provider site path: " +
                    url.getPath());
        }else if(response.getStatusCode().series() == HttpStatus.Series.CLIENT_ERROR){
        	logger.error("Client error on provider site path: "+url.getPath());
            throw  new TourismGenericClientException("Client error on provider site" + url.getPath(),
                    response.getStatusCode());
        }
    }

    @Override
    public void handleError(ClientHttpResponse response) throws IOException {
        if(response.getStatusCode().series() == HttpStatus.Series.SERVER_ERROR){
            throw new TourismGenericServerException("Internal server error on provider site");
        }else if(response.getStatusCode().series() == HttpStatus.Series.CLIENT_ERROR){
            throw  new TourismGenericClientException("Client error on provider site", 
            		response.getStatusCode());
        }
    }

}
