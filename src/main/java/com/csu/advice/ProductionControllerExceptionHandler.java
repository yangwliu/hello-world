package com.csu.advice;

import com.csu.controller.ProductionController;
import com.csu.exception.ProductionNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice(assignableTypes = ProductionController.class)
public class ProductionControllerExceptionHandler extends ResponseEntityExceptionHandler {
    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(ProductionNotFoundException.class)
    @SuppressWarnings("ThrowablePrintedToSystemOut")
    public void handleProductionNotFoundException(ProductionNotFoundException e) {
        System.out.println(e);
    }
}
