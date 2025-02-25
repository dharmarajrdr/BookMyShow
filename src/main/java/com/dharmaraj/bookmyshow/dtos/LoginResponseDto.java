package com.dharmaraj.bookmyshow.dtos;

import lombok.Data;

@Data
public class LoginResponseDto extends BaseResponse {

    private boolean loggedIn;

}
