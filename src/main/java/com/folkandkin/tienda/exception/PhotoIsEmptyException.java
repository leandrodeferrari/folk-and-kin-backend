package com.folkandkin.tienda.exception;

public class PhotoIsEmptyException extends RuntimeException {
    public PhotoIsEmptyException(String message) {
        super(message);
    }
}
