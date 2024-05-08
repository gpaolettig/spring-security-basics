package com.gino.springsecuritybasics;

import com.gino.springsecuritybasics.dto.CreateUserDto;
import com.gino.springsecuritybasics.entity.User;
import com.gino.springsecuritybasics.mappers.UserMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SpringSecurityBasicsApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringSecurityBasicsApplication.class, args);
	}
}
