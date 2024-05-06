package com.gino.springsecuritybasics.service.impl;

import com.gino.springsecuritybasics.dto.CreateUserDto;
import com.gino.springsecuritybasics.service.IUserService;
import com.gino.springsecuritybasics.enums.ErrorsEnum;
import com.gino.springsecuritybasics.exceptions.ApiException;
import com.gino.springsecuritybasics.service.IUserValidationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserValidationServiceImpl implements IUserValidationService {
    private final IUserService userService;
    @Override
    public void validate(CreateUserDto userDto) {
        if (userDto.getFirstName() == null) {
            throw new ApiException(ErrorsEnum.MISSING_FIRST_NAME.getMessage(), HttpStatus.BAD_REQUEST);
        }
        if (userDto.getLastName() == null) {
            throw new ApiException(ErrorsEnum.MISSING_LAST_NAME.getMessage(), HttpStatus.BAD_REQUEST);
        }
        if (!userDto.getEmail().matches("^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$")) {
            throw new ApiException(ErrorsEnum.INVALID_EMAIL.getMessage(), HttpStatus.BAD_REQUEST);
        }
        if (!userDto.getPassword().matches("^(?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[a-zA-Z]).{8,16}$")) {
            throw new ApiException(ErrorsEnum.INVALID_PASSWORD.getMessage(), HttpStatus.BAD_REQUEST);
        }
        if (userService.findUserByEmail(userDto.getEmail()).isPresent()) {
            throw new ApiException(ErrorsEnum.EXISTING_EMAIL.getMessage(), HttpStatus.CONFLICT);
        }
    }
}
