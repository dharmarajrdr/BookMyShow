package com.dharmaraj.bookmyshow.services;

import com.dharmaraj.bookmyshow.models.User;

public interface UserService {
    
    public User signupUser(String name, String email, String phone, String password) throws Exception;

    public boolean login(String email, String password) throws Exception;
}
