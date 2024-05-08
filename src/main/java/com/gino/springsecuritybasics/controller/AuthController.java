package com.gino.springsecuritybasics.controller;

import com.gino.springsecuritybasics.dto.CreateUserDto;
import com.gino.springsecuritybasics.dto.LoginDto;
import com.gino.springsecuritybasics.exceptions.ApiException;
import com.gino.springsecuritybasics.service.IAuthService;
import com.nimbusds.jose.JOSEException;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {
    private final IAuthService authService;

    @PostMapping("/register")
    @ResponseStatus(value = HttpStatus.CREATED)
    private void createUser(@RequestBody CreateUserDto createUserDto) throws ApiException {
        authService.register(createUserDto);
    }
    @PostMapping("/login")
    @ResponseStatus(value = HttpStatus.ACCEPTED)
    private String login(@RequestBody LoginDto loginDto) throws IOException, NoSuchAlgorithmException, InvalidKeySpecException, JOSEException, ApiException {
        return authService.login(loginDto);
    }


}
