package com.securly.syncservice.controller.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;


@RestControllerAdvice
public class CanvasExceptionHandler {

    @ExceptionHandler(CanvasAccountException.class)
    public ResponseEntity<String> handleCanvasAccountException(CanvasAccountException ex) {
        // Perform specific actions based on error codes
        switch (ex.getErrorCode()) {
            case ACCOUNT_CREATION_FAILED:
                return new ResponseEntity<>("Failed to create Canvas account.", HttpStatus.BAD_REQUEST);
            case ACCOUNT_UPDATE_FAILED:
                return new ResponseEntity<>("Failed to update Canvas account.", HttpStatus.BAD_REQUEST);
            // Handle other error codes...
            default:
                return new ResponseEntity<>("An error occurred with Canvas account.", HttpStatus.BAD_REQUEST);
        }
    }
    
    @ExceptionHandler(CanvasCourseException.class)
    public ResponseEntity<String> handleCanvasCourseException(CanvasCourseException ex) {
        // Perform specific actions based on error codes
        switch (ex.getErrorCode()) {
            case COURSE_CREATION_FAILED:
                return new ResponseEntity<>("Failed to create Canvas account.", HttpStatus.BAD_REQUEST);
            case COURSE_UPDATE_FAILED:
                return new ResponseEntity<>("Failed to update Canvas account.", HttpStatus.BAD_REQUEST);
            // Handle other error codes...
            default:
                return new ResponseEntity<>("An error occurred with Canvas account.", HttpStatus.BAD_REQUEST);
        }
    }
}