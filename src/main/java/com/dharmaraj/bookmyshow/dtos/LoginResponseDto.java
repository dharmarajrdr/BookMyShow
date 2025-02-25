package com.dharmaraj.bookmyshow.dtos;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
public class LoginResponseDto extends BaseResponse {

    private boolean loggedIn;

}
