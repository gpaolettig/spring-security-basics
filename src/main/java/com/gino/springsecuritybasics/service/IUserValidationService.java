package com.gino.springsecuritybasics.service;

import com.gino.springsecuritybasics.dto.CreateUserDto;

public interface IUserValidationService {
    void validate(CreateUserDto userDto);
}
