package com.unsa.tourism.errorhandler;

import org.apache.logging.log4j.Logger;

public class TourismConflictException extends RuntimeException {

	private Logger logger;

	private static final long serialVersionUID = 1L;
	
    public TourismConflictException() {
        super();
    }

    public TourismConflictException(String message, Throwable ex)	{
        super(message, ex);
    }

    public TourismConflictException(String message) {
        super(message);
    }

    public TourismConflictException(Throwable ex) {
        super(ex);
    }

	public Logger getLogger() {
		return logger;
	}

	public void setLogger(Logger logger) {
		this.logger = logger;
	}

}
