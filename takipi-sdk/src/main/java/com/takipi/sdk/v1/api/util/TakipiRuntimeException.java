package com.takipi.sdk.v1.api.util;

/**
 * Generic exception for problems occurring while performing various operations using the
 * Takipi SDK.
 * 
 * @author Niv Steingarten
 */
public class TakipiRuntimeException extends RuntimeException {

	private static final long serialVersionUID = -8082441752480631216L;
	
	public TakipiRuntimeException() {
		super();
	}
	
	public TakipiRuntimeException(String message) {
		super(message);
	}
	
	public TakipiRuntimeException(Throwable cause) {
		super(cause);
	}
	
	public TakipiRuntimeException(String message, Throwable cause) {
		super(message, cause);
	}
}
