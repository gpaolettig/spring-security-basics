package com.gino.springsecuritybasics.service.impl;

import com.gino.springsecuritybasics.dto.CreateUserDto;
import com.gino.springsecuritybasics.dto.LoginDto;
import com.gino.springsecuritybasics.entity.User;
import com.gino.springsecuritybasics.service.IUserService;
import com.gino.springsecuritybasics.enums.ErrorsEnum;
import com.gino.springsecuritybasics.exceptions.ApiException;
import com.gino.springsecuritybasics.service.IUserValidationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserValidationServiceImpl implements IUserValidationService {
    private final IUserService userService;
    private final PasswordEncoder encoder;

    @Override
    public void validateRegisterFields(CreateUserDto userDto) {
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
        Optional<User> userOptional = userService.findUserByEmail(userDto.getEmail());
        if (userOptional.isPresent()){
            throw new ApiException(ErrorsEnum.EXISTING_EMAIL.getMessage(), HttpStatus.CONFLICT);
        }
    }
    public User validateLoginFields(LoginDto loginDto) {
        Optional<User> userOptional = userService.findUserByEmail(loginDto.getEmail());
        if (userOptional.isEmpty()){
            throw new ApiException(ErrorsEnum.USER_NOT_REGISTERED.getMessage(), HttpStatus.NOT_FOUND);
        }
        //the matches method compares an unencrypted password with an encrypted password
        if (!encoder.matches(loginDto.getPassword(), userOptional.get().getPassword())) {
            throw new ApiException(ErrorsEnum.INCORRECT_PASSWORD.getMessage(), HttpStatus.NOT_FOUND);
        }
        return userOptional.get();
    }
}
