package com.dharmaraj.bookmyshow.models;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Cast extends BaseModel{

    private String name;
    private String characterName;
    private String image;
}
