package com.dharmaraj.bookmyshow.dtos;

import lombok.Data;

@Data
public class SignupUserResponseDTO extends BaseResponse {

    private long userId;
    private String name;
    private String email;
    private String phone;
}
