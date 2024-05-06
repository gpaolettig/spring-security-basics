package com.gino.springsecuritybasics.exceptions;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
@RequiredArgsConstructor
public class ApiException extends RuntimeException{
    private final String message;
    private final HttpStatus httpStatusCode;
}
