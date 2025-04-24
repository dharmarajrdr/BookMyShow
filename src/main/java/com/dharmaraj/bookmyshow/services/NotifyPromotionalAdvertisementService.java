package com.dharmaraj.bookmyshow.services;

import com.dharmaraj.bookmyshow.dtos.NotificationDto;
import com.dharmaraj.bookmyshow.models.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NotifyPromotionalAdvertisementService {

    private NotificationSerice notificationSerice;

    public NotifyPromotionalAdvertisementService(NotificationSerice notificationSerice) {

        this.notificationSerice = notificationSerice;
    }

    public void notifyPromotionalAdvertisement(String message, List<User> users) {

        for (User user : users) {
            NotificationDto notificationDto = new NotificationDto();
            notificationDto.setUser(user);
            notificationDto.setMessage(message);
            notificationSerice.notify(notificationDto);
        }
    }
}
