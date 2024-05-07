package com.gino.springsecuritybasics.service;

import com.gino.springsecuritybasics.dto.CreateUserDto;
import com.gino.springsecuritybasics.dto.LoginDto;
import com.gino.springsecuritybasics.entity.User;

public interface IUserValidationService {
    void validateRegisterFields(CreateUserDto userDto);
    User validateLoginFields(LoginDto loginDto);
}
