package com.dharmaraj.bookmyshow.dtos;

import lombok.Data;

@Data
public class SignupUserResponseDTO {

    private long userId;
    private String name;
    private String email;
    private String phone;
    private ResponseStatus responseStatus;
}
