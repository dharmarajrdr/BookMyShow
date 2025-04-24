package com.dharmaraj.bookmyshow.dtos;

import com.dharmaraj.bookmyshow.models.User;
import lombok.Data;

@Data
public class NotificationDto {

    private User user;

    private String message;
}
