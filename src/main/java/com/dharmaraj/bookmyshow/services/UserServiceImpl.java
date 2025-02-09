package com.dharmaraj.bookmyshow.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.dharmaraj.bookmyshow.models.User;
import com.dharmaraj.bookmyshow.repositories.UserRepository;

public class UserServiceImpl implements UserService {

    private UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User signupUser(String name, String email, String phone, String password) throws Exception {

        Optional<User> optionalUser = this.userRepository.findUserByEmail(email);
        if (optionalUser.isPresent()) {
            throw new Exception("User already exists");
        }
        
        String encryptedPassword = new BCryptPasswordEncoder().encode(password);
        return this.userRepository.save(new User(name, email, phone, encryptedPassword));
    }

    public boolean login(String email, String password) throws Exception {

        Optional<User> optionalUser = this.userRepository.findUserByEmail(email);
        if (optionalUser.isEmpty()) {
            throw new Exception("User does not exist");
        }

        User user = optionalUser.get();
        return isCorrectPassword(password, user.getPassword());
    }

    private boolean isCorrectPassword(String rawPassword, String hashedPassword) {

        return BCrypt.checkpw(rawPassword, hashedPassword); // Using BCrypt for secure password comparison
    }

}
