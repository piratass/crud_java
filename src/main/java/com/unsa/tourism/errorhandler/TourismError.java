package com.unsa.tourism.errorhandler;

import org.springframework.http.HttpStatus;

import java.util.Date;
import java.util.List;

public class TourismError {

    private String code;
    private HttpStatus httpStatus;
    private Date timestamp;
    private String message;
    private String debugMessage;
    private List<TourismSubError> subErrors;

    private TourismError() {
        timestamp = new Date();
    }

    public TourismError(HttpStatus httpStatus, String code) {
        this();
        this.code = code;
        this.httpStatus = httpStatus;
    }

    public TourismError(HttpStatus httpStatus, String code, Throwable e) {
        this();
        this.code = code;
        this.httpStatus = httpStatus;
        this.message = "Unexpected error";
        this.debugMessage = e.getLocalizedMessage();
    }

    public TourismError(HttpStatus httpStatus, String code, String message, Throwable e) {
        this();
        this.code = code;
        this.httpStatus = httpStatus;
        this.message = message;
        this.debugMessage = e.getLocalizedMessage();
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public HttpStatus getHttpStatus() {
        return httpStatus;
    }

    public void setHttpStatus(HttpStatus httpStatus) {
        this.httpStatus = httpStatus;
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getDebugMessage() {
        return debugMessage;
    }

    public void setDebugMessage(String debugMessage) {
        this.debugMessage = debugMessage;
    }

    public List<TourismSubError> getSubErrors() {
        return subErrors;
    }

    public void setSubErrors(List<TourismSubError> subErrors) {
        this.subErrors = subErrors;
    }
}
