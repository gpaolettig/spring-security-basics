package com.gino.springsecuritybasics.validation.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Arrays;
import java.util.Objects;

@AllArgsConstructor
@Getter
public enum ErrorsEnum {
    MISSING_FIRST_NAME ("001","The name is mandatory"),
    MISSING_LAST_NAME ("002","The lastname is mandatory"),
    INVALID_EMAIL ("003","The email address is invalid"),
    INVALID_PASSWORD ("004","The password must contain between 8 and 16 characters, at least one number, one lowercase and one uppercase letter"),
    DEFAULT ("000","Not captured error");
    private final String code;
    private final String message;

    public static ErrorsEnum getTypeByCode(String code) {
        return Arrays.stream(ErrorsEnum.values())
                .filter(error -> Objects.equals(error.getCode(), code))
                .findFirst()
                .orElse(ErrorsEnum.DEFAULT);
    }
}
