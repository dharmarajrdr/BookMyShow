package com.dharmaraj.bookmyshow.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity
public class Screen extends BaseModel {

    private String name;

    @OneToMany
    private List<Seat> seats;

    @Enumerated(EnumType.ORDINAL)
    @ElementCollection
    private List<Feature> features;
}

/**
 * Screen : Seat ( 1 : M )
 * 1 : M        => One screen can have many seat
 * 1 : 1        => One seat will be in that particular screen
 */