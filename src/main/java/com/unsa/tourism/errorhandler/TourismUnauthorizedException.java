package com.unsa.tourism.errorhandler;

import org.apache.logging.log4j.Logger;

public class TourismUnauthorizedException extends RuntimeException {

	private Logger logger;

	private static final long serialVersionUID = 1L;
    public TourismUnauthorizedException() {
        super();
    }

    public TourismUnauthorizedException(String message, Throwable ex)	{
        super(message, ex);
    }

    public TourismUnauthorizedException(String message) {
        super(message);
    }

    public TourismUnauthorizedException(Throwable ex) {
        super(ex);
    }

	public Logger getLogger() {
		return logger;
	}

	public void setLogger(Logger logger) {
		this.logger = logger;
	}

}
