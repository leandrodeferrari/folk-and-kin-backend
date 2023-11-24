package com.folkandkin.tienda.exception;

public class CategoryIsEmptyException extends RuntimeException {
    public CategoryIsEmptyException(String message) {
        super(message);
    }
}
