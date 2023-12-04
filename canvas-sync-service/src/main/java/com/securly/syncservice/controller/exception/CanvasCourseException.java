package com.securly.syncservice.controller.exception;

public class CanvasCourseException extends RuntimeException {

	/**
	 *  serialVersionUID
	 */
	private static final long serialVersionUID = 1L;

	public enum ErrorCode {
		COURSE_CREATION_FAILED, COURSE_UPDATE_FAILED, 
		// Add more specific error codes as needed
	}

	private final ErrorCode errorCode;

	public CanvasCourseException(String message, ErrorCode errorCode) {
		super(message);
		this.errorCode = errorCode;
	}

	public ErrorCode getErrorCode() {
		return errorCode;
	}
}
