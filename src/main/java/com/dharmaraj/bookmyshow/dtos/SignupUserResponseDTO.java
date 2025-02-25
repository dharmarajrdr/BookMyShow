package com.dharmaraj.bookmyshow.dtos;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
public class SignupUserResponseDTO extends BaseResponse {

    private long userId;
    private String name;
    private String email;
    private String phone;
}
