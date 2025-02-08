package com.dharmaraj.bookmyshow.models;

import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@Entity(name = "users")
public class User extends BaseModel {

    private String name;

    private String email;

    private String password;
}
