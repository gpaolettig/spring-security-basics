package com.gino.springsecuritybasics.service;

import com.gino.springsecuritybasics.dto.CreateUserDto;
import com.gino.springsecuritybasics.dto.LoginDto;
import com.gino.springsecuritybasics.entity.User;
import com.gino.springsecuritybasics.exceptions.ApiException;

public interface IUserValidationService {
    void validateRegisterFields(CreateUserDto userDto) throws ApiException;
    User validateLoginFields(LoginDto loginDto) throws ApiException;
}
