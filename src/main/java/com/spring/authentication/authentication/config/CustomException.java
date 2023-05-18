package com.spring.authentication.authentication.config;


import org.springframework.boot.context.config.ConfigDataResourceNotFoundException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@RestControllerAdvice
public class CustomException extends ResponseEntityExceptionHandler {

    @ExceptionHandler(value = {IllegalArgumentException.class})
    @ResponseStatus(HttpStatus.FORBIDDEN)
    public ResponseEntity<Object> errorHandler(IllegalArgumentException exception , WebRequest req) {
        String responseString = "Illegal argument";
        return handleExceptionInternal(exception,responseString , new HttpHeaders(), HttpStatus.BAD_REQUEST , req);
    }
}
