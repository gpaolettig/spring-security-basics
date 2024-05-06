package com.gino.springsecuritybasics.service;

import com.gino.springsecuritybasics.dto.CreateUserDto;
import com.gino.springsecuritybasics.entity.User;

import java.util.Optional;

public interface IUserService {
    void createUser(CreateUserDto createUserDto);
    Optional<User> findUserByEmail(String email);

}
