package com.dharmaraj.bookmyshow.models;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity
public class City extends BaseModel {

    private String name;

    @OneToMany(mappedBy = "city")
    private List<Theatre> theatres;
}

/**
 * City : Theatre ( 1 : M )
 * 1 : M         =>  One city will have many theatre
 * 1 : 1         =>  One theatre will belongs to one city
 */