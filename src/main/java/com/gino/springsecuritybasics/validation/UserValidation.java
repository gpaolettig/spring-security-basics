package com.gino.springsecuritybasics.validation;

import com.gino.springsecuritybasics.dto.CreateUserDto;
import com.gino.springsecuritybasics.validation.enums.ErrorsEnum;
import org.springframework.stereotype.Component;

@Component
public class UserValidation {
    public void validate(CreateUserDto userDto) {
        if (userDto.getFirstName() == null) {
            throw new IllegalArgumentException(ErrorsEnum.MISSING_FIRST_NAME.getMessage());
        }
        if (userDto.getLastName() == null) {
            throw new IllegalArgumentException(ErrorsEnum.MISSING_LAST_NAME.getMessage());
        }
        if (!userDto.getEmail().matches("^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$")) {
            throw new IllegalArgumentException(ErrorsEnum.INVALID_EMAIL.getMessage());
        }
        if (!userDto.getPassword().matches("^(?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[a-zA-Z]).{8,16}$")) {
            throw  new IllegalArgumentException(ErrorsEnum.INVALID_PASSWORD.getMessage());
        }
    }
}
