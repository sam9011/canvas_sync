package com.securly.syncservice.controller.exception;

public class CanvasAccountException extends RuntimeException {

	/**
	 *  serialVersionUID
	 */
	private static final long serialVersionUID = 1L;

	public enum ErrorCode {
		ACCOUNT_CREATION_FAILED, ACCOUNT_UPDATE_FAILED, ACCOUNT_DELETION_FAILED,
		// Add more specific error codes as needed
	}

	private final ErrorCode errorCode;

	public CanvasAccountException(String message, ErrorCode errorCode) {
		super(message);
		this.errorCode = errorCode;
	}

	public ErrorCode getErrorCode() {
		return errorCode;
	}
}
