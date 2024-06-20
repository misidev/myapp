package com.myapp.spring_myapp_service.exceptions;

import com.myapp.spring_myapp_service.model.response.ErrorResponse;

public class UserValidationException extends IllegalArgumentException {

    private ErrorResponse errorResponse;

    public UserValidationException(String message, ErrorResponse errorResponse) {
        super(message);
        this.errorResponse= errorResponse;
    }

    public UserValidationException() {

    }

    public ErrorResponse getErrorResponse() {
        return errorResponse;
    }
}
