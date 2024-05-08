package com.gino.springsecuritybasics.mappers;

import com.gino.springsecuritybasics.dto.CreateUserDto;
import com.gino.springsecuritybasics.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Mapper(componentModel = "spring")
public interface UserMapper {

    @Mapping(source = "password", target = "password",qualifiedByName = "Encoder")
    User CreateUserDtoToUser(CreateUserDto createUserDto);

    @Named("Encoder")
    default String encoderPassword(String password){
        PasswordEncoder passwordEncoder = new BCryptPasswordEncoder(12);
        return passwordEncoder.encode(password);
    }
}
