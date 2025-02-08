package com.dharmaraj.bookmyshow.controllers;

import com.dharmaraj.bookmyshow.dtos.ResponseStatus;
import com.dharmaraj.bookmyshow.dtos.UserRequestDto;
import com.dharmaraj.bookmyshow.dtos.UserResponseDto;
import com.dharmaraj.bookmyshow.models.User;
import com.dharmaraj.bookmyshow.services.UserService;
import org.springframework.stereotype.Controller;

@Controller
public class UserController {

    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    public UserResponseDto addUser(UserRequestDto userRequestDto) {

        UserResponseDto userResponseDto = new UserResponseDto();
        try {
            String name = userRequestDto.getName();
            String email = userRequestDto.getEmail();
            String phone = userRequestDto.getPhone();
            User user = this.userService.addUser(name, email, phone);
            userResponseDto.setUser(user);
            userResponseDto.setResponseStatus(ResponseStatus.SUCCESS);
        } catch (Exception e) {
            userResponseDto.setResponseStatus(ResponseStatus.FAILURE);
            userResponseDto.setMessage(e.getMessage());
        }
        return userResponseDto;
    }
}
