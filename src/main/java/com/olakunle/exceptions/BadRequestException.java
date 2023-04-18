package com.olakunle.exceptions;

public class BadRequestException extends RuntimeException{
    public BadRequestException() {}
    public BadRequestException(String message) {
        super(message);
    }

    public BadRequestException(String message, Throwable throwable) {
        super(message, throwable);
    }

}
