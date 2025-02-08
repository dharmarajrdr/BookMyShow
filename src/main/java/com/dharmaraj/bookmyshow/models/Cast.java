package com.dharmaraj.bookmyshow.models;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Cast extends BaseModel{

    private String name;
    private String characterName;
    private String image;
}
