package com.dharmaraj.bookmyshow.models;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name = "casts")
public class Cast extends BaseModel{

    private String name;

    private String characterName;

    private String image;
}
