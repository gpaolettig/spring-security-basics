package com.gino.springsecuritybasics.controller.advice;

import com.gino.springsecuritybasics.error.ApiError;
import com.gino.springsecuritybasics.validation.enums.ErrorsEnum;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;



@RestControllerAdvice
public class ControllerAdvice {

    @ExceptionHandler({IllegalArgumentException.class})
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ApiError illegalArgumentExceptionHandler(IllegalArgumentException exception) {
        ErrorsEnum errorsEnum = ErrorsEnum.getTypeByCode(exception.getMessage());
        return new ApiError(errorsEnum.getCode(),errorsEnum.getMessage());
    }
}
