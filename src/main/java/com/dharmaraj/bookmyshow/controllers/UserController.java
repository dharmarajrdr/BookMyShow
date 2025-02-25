package com.dharmaraj.bookmyshow.controllers;

import com.dharmaraj.bookmyshow.dtos.LoginRequestDto;
import com.dharmaraj.bookmyshow.dtos.LoginResponseDto;
import com.dharmaraj.bookmyshow.dtos.ResponseStatus;
import com.dharmaraj.bookmyshow.dtos.SignupUserRequestDTO;
import com.dharmaraj.bookmyshow.dtos.SignupUserResponseDTO;
import com.dharmaraj.bookmyshow.models.User;
import com.dharmaraj.bookmyshow.services.UserService;
import org.springframework.stereotype.Controller;

@Controller
public class UserController {

    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    public SignupUserResponseDTO signupUser(SignupUserRequestDTO requestDTO) {
        
        SignupUserResponseDTO signupUserResponseDTO = new SignupUserResponseDTO();
        try {
            String name = requestDTO.getName();
            String email = requestDTO.getEmail();
            String password = requestDTO.getPassword();
            String phone = requestDTO.getPhone();
            User user = this.userService.signupUser(name, email, phone, password);
            signupUserResponseDTO.setEmail(email);
            signupUserResponseDTO.setName(name);
            signupUserResponseDTO.setResponseStatus(ResponseStatus.SUCCESS);
            signupUserResponseDTO.setUserId(user.getId());
        } catch (Exception e) {
            signupUserResponseDTO.setResponseStatus(ResponseStatus.FAILURE);
        }
        return signupUserResponseDTO;
    }

    public LoginResponseDto login(LoginRequestDto requestDto) {
        
        LoginResponseDto loginResponseDto = new LoginResponseDto();
        try {
            String email = requestDto.getEmail();
            String password = requestDto.getPassword();
            boolean loggedIn = this.userService.login(email, password);
            loginResponseDto.setLoggedIn(loggedIn);
            loginResponseDto.setResponseStatus(ResponseStatus.SUCCESS);
        } catch (Exception e) {
            loginResponseDto.setLoggedIn(false);
            loginResponseDto.setResponseStatus(ResponseStatus.FAILURE);
        }
        return loginResponseDto;
    }
}
