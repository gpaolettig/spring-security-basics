package com.gino.springsecuritybasics.validation.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum ErrorsEnum {
    MISSING_FIRST_NAME ("The name is mandatory"),
    MISSING_LAST_NAME ("The lastname is mandatory"),
    INVALID_EMAIL ("The email address is invalid"),
    INVALID_PASSWORD ("The password must contain between 8 and 16 characters, at least one number, one lowercase and one uppercase letter");
    private final String message;

}
