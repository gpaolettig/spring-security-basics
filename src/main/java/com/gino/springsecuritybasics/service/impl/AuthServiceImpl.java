package com.gino.springsecuritybasics.service.impl;

import com.gino.springsecuritybasics.dto.CreateUserDto;
import com.gino.springsecuritybasics.entity.User;
import com.gino.springsecuritybasics.service.IAuthService;
import com.gino.springsecuritybasics.service.IUserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements IAuthService {
    private final IUserService userService;
    private final UserValidationServiceImpl userValidationServiceImpl;

    public void register(CreateUserDto createUserDto) {
        userValidationServiceImpl.validate(createUserDto);
        userService.createUser(createUserDto);


    }
}
