package com.gino.springsecuritybasics.error;

import lombok.AllArgsConstructor;
import lombok.Data;


@Data
@AllArgsConstructor
public class ApiError {
    String code;
    String message;

}
