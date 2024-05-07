package com.gino.springsecuritybasics.service.impl;

import com.gino.springsecuritybasics.dto.CreateUserDto;
import com.gino.springsecuritybasics.dto.LoginDto;
import com.gino.springsecuritybasics.entity.User;
import com.gino.springsecuritybasics.service.IAuthService;
import com.gino.springsecuritybasics.service.IJWTService;
import com.gino.springsecuritybasics.service.IUserService;
import com.gino.springsecuritybasics.service.IUserValidationService;
import com.nimbusds.jose.JOSEException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;


@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements IAuthService {
    private final IUserService userService;
    private final IUserValidationService userValidationServiceImpl;
    private final IJWTService jwtService;

    public void register(CreateUserDto createUserDto) {
        userValidationServiceImpl.validateRegisterFields(createUserDto);
        userService.createUser(createUserDto);
    }
    @Override
    public String login(LoginDto loginDto) throws IOException, NoSuchAlgorithmException, InvalidKeySpecException, JOSEException {
        User user = userValidationServiceImpl.validateLoginFields(loginDto);
        return jwtService.generateJWT(user.getId());
    }
}
