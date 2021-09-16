package com.unsa.tourism.errorhandler;

public class TourismValidationError extends TourismSubError {

    private String object;
    private String field;
    private Object rejectValue;
    private String message;

    public TourismValidationError(String object, String message) {
        this.object = object;
        this.message = message;
    }

    public TourismValidationError(String object, String field, Object rejectValue, String message) {
        this.object = object;
        this.field = field;
        this.rejectValue = rejectValue;
        this.message = message;
    }

    public String getObject() {
        return object;
    }

    public void setObject(String object) {
        this.object = object;
    }

    public String getField() {
        return field;
    }

    public void setField(String field) {
        this.field = field;
    }

    public Object getRejectValue() {
        return rejectValue;
    }

    public void setRejectValue(Object rejectValue) {
        this.rejectValue = rejectValue;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

}
