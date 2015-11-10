package com.arborsoft.catalog.exception;

public class ApplicationException extends Exception {
    public ApplicationException() {
    }

    public ApplicationException(String message) {
        super(message);
    }

    public ApplicationException(String message, Throwable throwable) {
        super(message, throwable);
    }
}
