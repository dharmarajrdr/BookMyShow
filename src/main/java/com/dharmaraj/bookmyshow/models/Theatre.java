package com.dharmaraj.bookmyshow.models;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class Theatre extends BaseModel {

    private String name;
    private List<Seat> seats;
    private List<Feature> features;
}
