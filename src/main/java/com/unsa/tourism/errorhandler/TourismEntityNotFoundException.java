package com.unsa.tourism.errorhandler;

import org.apache.logging.log4j.Logger;

public class TourismEntityNotFoundException extends RuntimeException {
	
	private Logger logger;

	private static final long serialVersionUID = 1L;

    public TourismEntityNotFoundException() {
        super();
    }

    public TourismEntityNotFoundException(String message, Throwable ex)	{
        super(message, ex);
    }
    //new spring 6
	public TourismEntityNotFoundException(String message, Throwable ex, Logger logger)	{
		super(message, ex);
		this.logger=logger;
	}

    public TourismEntityNotFoundException(String message) {
        super(message);
    }

    //new spring 6
	public TourismEntityNotFoundException(String message, Logger logger) {
		super(message);
		this.logger=logger;
	}
	
    public TourismEntityNotFoundException(Throwable ex) {
        super(ex);
    }
    
    //new spring 6
	public Logger getLogger() {
		return logger;
	}

	 //new spring 6
	public void setLogger(Logger logger) {
		this.logger = logger;
	}

}
