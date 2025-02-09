package com.dharmaraj.bookmyshow.repositories;

import com.dharmaraj.bookmyshow.models.User;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

    public User save(User user);

    public Optional<User> findUserByEmail(String email);

    public Optional<User> findById(Integer integer);
}
