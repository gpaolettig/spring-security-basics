package com.gino.springsecuritybasics.dto;

import lombok.Data;

@Data
public class LoginDto {
    private String email;
    private String password;
}
