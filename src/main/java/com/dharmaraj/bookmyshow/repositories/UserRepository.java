package com.dharmaraj.bookmyshow.repositories;

import com.dharmaraj.bookmyshow.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

    public User save(User user);
}
