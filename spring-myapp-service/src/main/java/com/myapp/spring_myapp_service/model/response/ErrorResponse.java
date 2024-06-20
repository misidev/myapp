package com.myapp.spring_myapp_service.model.response;

import org.springframework.http.HttpStatus;

public class ErrorResponse {

    private Error error;


    public ErrorResponse(Error error) {

        this.error = error;
    }

    public Error getError() {
        return error;
    }

    public void setError(Error error) {
        this.error = error;
    }

    @Override
    public String toString() {
        return "ErrorResponse{" +
                "error=" + error +
                '}';
    }

    public static class Error {
        String status;
        Integer code;
        String message;
        String details;
        public Error(String status, Integer code, String message, String details) {
            this.status = status;
            this.code = code;
            this.message = message;
            this.details = details;
        }


        public Integer getCode() {
            return code;
        }

        public void setCode(Integer code) {
            this.code = code;
        }

        public String getMessage() {
            return message;
        }

        public void setMessage(String message) {
            this.message = message;
        }

        public String getDetails() {
            return details;
        }

        public void setDetails(String details) {
            this.details = details;
        }

        public String getStatus() {
            return status;
        }

        public void setStatus(String status) {
            this.status = status;
        }

        @Override
        public String toString() {
            return "Error{" +
                    "status='" + status + '\'' +
                    ", code=" + code +
                    ", message='" + message + '\'' +
                    ", details='" + details + '\'' +
                    '}';
        }
    }
}
