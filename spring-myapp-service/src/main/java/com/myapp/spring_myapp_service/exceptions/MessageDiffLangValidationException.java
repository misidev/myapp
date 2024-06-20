package com.myapp.spring_myapp_service.exceptions;


import com.myapp.spring_myapp_service.model.response.ErrorResponse;

public class MessageDiffLangValidationException extends IllegalArgumentException {

    private ErrorResponse errorResponse;

    public MessageDiffLangValidationException(String message, ErrorResponse errorResponse) {
        super(message);
        this.errorResponse= errorResponse;
    }

    public MessageDiffLangValidationException() {

    }

    public ErrorResponse getErrorResponse() {
        return errorResponse;
    }
}
