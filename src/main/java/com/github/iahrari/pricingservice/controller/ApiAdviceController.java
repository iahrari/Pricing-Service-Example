package com.github.iahrari.pricingservice.controller;

import com.github.iahrari.pricingservice.controller.exception.QueryException;
import com.github.iahrari.pricingservice.domain.QueryError;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ApiAdviceController {
    
    @ExceptionHandler(QueryException.class)
    @ResponseStatus(value = HttpStatus.BAD_REQUEST)
    public QueryError handleQueryException(QueryException ex) {
        return ex.getError();
    }
}
