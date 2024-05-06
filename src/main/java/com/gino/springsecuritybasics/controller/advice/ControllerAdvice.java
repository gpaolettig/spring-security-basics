package com.gino.springsecuritybasics.controller.advice;

import com.gino.springsecuritybasics.exceptions.ApiException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;



@RestControllerAdvice
public class ControllerAdvice {
    @ExceptionHandler({ApiException.class})
    public ApiException illegalArgumentExceptionHandler(ApiException exception) {
        return exception;
    }
}
