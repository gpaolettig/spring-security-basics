package com.gino.springsecuritybasics.service.impl;

import com.gino.springsecuritybasics.dto.CreateUserDto;
import com.gino.springsecuritybasics.entity.User;
import com.gino.springsecuritybasics.mappers.UserMapper;
import com.gino.springsecuritybasics.repository.UserRepository;
import com.gino.springsecuritybasics.service.IUserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements IUserService {
    private final UserRepository userRepository;
    private final UserMapper userMapper;

    @Override
    public void createUser(CreateUserDto createUserDto) {
        User user = userMapper.CreateUserDtoToUser(createUserDto);
        userRepository.save(user);
    }
    @Override
    public Optional<User> findUserByEmail(String email) {
        return userRepository.findByEmail(email);
    }
}
