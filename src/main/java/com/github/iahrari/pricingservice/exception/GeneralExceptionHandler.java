package com.github.iahrari.pricingservice.exception;

import java.util.HashMap;
import java.util.Map;

import com.github.iahrari.pricingservice.dto.ResponseError;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GeneralExceptionHandler {
    
    @ExceptionHandler(PriceRequestFieldsException.class)
    public ResponseEntity<Map<String, String>> handleQueryException(PriceRequestFieldsException ex) {
        return ResponseEntity.badRequest().body(ex.getFields());
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String, String>> handleValidationExceptions(
        MethodArgumentNotValidException ex
    ) {
        Map<String, String> errors = new HashMap<>();
        ex.getBindingResult().getFieldErrors().forEach((error) -> {
            String fieldName = error.getField();
            String errorMessage = error.getDefaultMessage();
            errors.put(fieldName, errorMessage);
        });
        return ResponseEntity
                .badRequest()
                .body(errors);
    }

    @ExceptionHandler(UserAuthenticationException.class)
    public ResponseEntity<ResponseError> handleUserAuthenticationErrors(UserAuthenticationException ex){
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED)
                .body(ResponseError.builder()
                        .message(ex.getMessage())
                        .build()
                );
    }
}
