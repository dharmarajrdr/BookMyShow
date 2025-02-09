package com.dharmaraj.bookmyshow.dtos;

import lombok.Data;

@Data
public class LoginRequestDto {

    private String email;
    private String password;
}
