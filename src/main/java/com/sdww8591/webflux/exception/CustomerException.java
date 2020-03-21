package com.sdww8591.webflux.exception;

public class CustomerException extends RuntimeException {

    private int statusCode;

    public CustomerException(int statusCode, String message) {
        super(message);
        this.statusCode = statusCode;
    }

    public int getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(int statusCode) {
        this.statusCode = statusCode;
    }
}
