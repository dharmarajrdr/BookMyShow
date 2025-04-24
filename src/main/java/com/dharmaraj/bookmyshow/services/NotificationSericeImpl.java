package com.dharmaraj.bookmyshow.services;

import com.dharmaraj.bookmyshow.dtos.NotificationDto;
import com.dharmaraj.bookmyshow.models.User;
import org.springframework.stereotype.Service;

@Service
public class NotificationSericeImpl implements NotificationSerice {

    @Override
    public void Notify(NotificationDto notificationDto) {

        User user = notificationDto.getUser();
        String message = notificationDto.getMessage();
        System.out.println("Message '" + message + "' sent to " + user.getEmail());
    }
}
