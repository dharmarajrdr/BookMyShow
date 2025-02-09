package com.dharmaraj.bookmyshow.dtos;

import lombok.Data;

@Data
public class SignupUserRequestDTO {

    private String name;
    private String email;
    private String phone;
    private String password;
}
