package com.myapp.spring_myapp_service.advice;

import com.myapp.spring_myapp_service.exceptions.MessageDiffLangValidationException;
import com.myapp.spring_myapp_service.exceptions.UserValidationException;
import com.myapp.spring_myapp_service.model.response.ErrorResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletResponse;

@ControllerAdvice
public class GlobalExceptionHandler {
    private static final Logger LOGGER = LoggerFactory.getLogger(GlobalExceptionHandler.class);
    private static final String STATUS = "failure";
    private static final String MESSAGE = "Internal Server Error";
    private static final String DETAILS = "Validation data input Error while saving user in DB: ";
    private static final String DETAILS_DIFF_LANG = "Validation data input Error while saving message for different language in DB ";


    //Error while saving user in DB
    @ExceptionHandler(UserValidationException.class)
    public ResponseEntity<ErrorResponse> handleUserValidationException(UserValidationException ex) {
        String details = DETAILS + ex.getClass().getSimpleName();
        ErrorResponse.Error error = new ErrorResponse.Error(
                STATUS,
                HttpServletResponse.SC_INTERNAL_SERVER_ERROR,
                MESSAGE,
                details);

        ErrorResponse errorResponse = new ErrorResponse(error);

        LOGGER.info(DETAILS + " {}, {}", ex.getClass().getSimpleName(), HttpStatus.INTERNAL_SERVER_ERROR);
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body(errorResponse);
    }

    //Error while saving user in DB
    @ExceptionHandler(MessageDiffLangValidationException.class)
    public ResponseEntity<ErrorResponse> handleMessageDifLangValidationException(MessageDiffLangValidationException ex) {
        String details = DETAILS_DIFF_LANG + ex.getClass().getSimpleName();
        ErrorResponse.Error error = new ErrorResponse.Error(
                STATUS,
                HttpServletResponse.SC_INTERNAL_SERVER_ERROR,
                MESSAGE,
                details);

        ErrorResponse errorResponse = new ErrorResponse(error);

        LOGGER.info(DETAILS_DIFF_LANG + " {}, {}", ex.getClass().getSimpleName(), HttpStatus.INTERNAL_SERVER_ERROR);
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body(errorResponse);
    }

}
