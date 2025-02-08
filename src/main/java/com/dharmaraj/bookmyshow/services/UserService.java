package com.dharmaraj.bookmyshow.services;

import com.dharmaraj.bookmyshow.models.User;
import com.dharmaraj.bookmyshow.repositories.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User addUser(String name, String email, String phone) {

        User user = new User(name, email, phone);
        this.userRepository.save(user);
        return user;
    }
}
