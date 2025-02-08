package com.dharmaraj.bookmyshow.models;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity
public class Theatre extends BaseModel {

    private String name;

    @OneToMany
    private List<Screen> screens;

    @ManyToOne
    private City city;
}

/**
 * Theatre : Screen ( 1 : M )
 * 1 : M        =>  One theatre will have many screens
 * 1 : 1        =>  One screen corresponds to one theatre
 */

/**
 * City : Theatre ( 1 : M )
 * 1 : M         =>  One city will have many theatre
 * 1 : 1         =>  One theatre will belongs to one city
 */

