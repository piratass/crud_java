package com.unsa.tourism.errorhandler;

import org.springframework.http.HttpStatus;

import java.util.List;
import org.apache.logging.log4j.Logger;

public class TourismGenericClientException extends RuntimeException {

    private HttpStatus httpStatus;
    //new spring 6
	private Logger logger;
	private String level;
    private List<TourismSubError> subErrors;

    public TourismGenericClientException() {
        super();
    }

    public TourismGenericClientException(String message, Throwable ex) {
        super(message, ex);
    }

    public TourismGenericClientException(String message) {
        super(message);
    }

    public TourismGenericClientException(String message, HttpStatus httpStatus) {
        super(message);
        this.httpStatus = httpStatus;
    }

    public TourismGenericClientException(Throwable ex) {
        super(ex);
    }

    public HttpStatus getHttpStatus() {
        return httpStatus;
    }

    public void setHttpStatus(HttpStatus httpStatus) {
        this.httpStatus = httpStatus;
    }

    public List<TourismSubError> getSubErrors() {
        return subErrors;
    }

    public void setSubErrors(List<TourismSubError> subErrors) {
        this.subErrors = subErrors;
    }

	public Logger getLogger() {
		return logger;
	}

	public void setLogger(Logger logger) {
		this.logger = logger;
	}

	public String getLevel() {
		return level;
	}

	public void setLevel(String level) {
		this.level = level;
	}
}
