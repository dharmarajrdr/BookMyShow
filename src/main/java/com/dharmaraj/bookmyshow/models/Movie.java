package com.dharmaraj.bookmyshow.models;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class Movie extends BaseModel {

    private String name;
    private List<Cast> cast;
}
