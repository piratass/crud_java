package com.unsa.tourism.errorhandler;
import org.apache.logging.log4j.Logger;

public class TourismGenericServerException extends RuntimeException {

	private static final long serialVersionUID = 1L;
    private String code;
	private Logger logger;
	
    public TourismGenericServerException() {
        super();
    }

    public TourismGenericServerException(String message, Throwable ex) {
        super(message, ex);
    }

    public TourismGenericServerException(String message) {
        super(message);
    }

    public TourismGenericServerException(String message, String code) {
        super(message);
        this.code = code;
    }

    public TourismGenericServerException(Throwable ex) {
        super(ex);
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
    
	public Logger getLogger() {
		return logger;
	}

	public void setLogger(Logger logger) {
		this.logger = logger;
	}

}
