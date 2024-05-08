package com.gino.springsecuritybasics.exceptions;

import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
@RequiredArgsConstructor
@Data
public class ApiException extends Exception{
    private final String message;
    private final HttpStatus httpStatusCode;
}
