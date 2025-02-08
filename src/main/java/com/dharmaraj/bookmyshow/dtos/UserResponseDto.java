package com.dharmaraj.bookmyshow.dtos;

import com.dharmaraj.bookmyshow.models.User;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserResponseDto extends BaseResponse {

    private User user;
}
