package com.csu.exception;

public class ProductionNotFoundException extends RuntimeException {

    public ProductionNotFoundException(String code) {
        super(code);
    }
}
