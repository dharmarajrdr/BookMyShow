package com.dharmaraj.bookmyshow.models;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity
public class Movie extends BaseModel {

    private String name;

    @ManyToMany
    private List<Cast> cast;
}


/**
 * Movie : Cast ( M : M )
 * 1 : M    => One movie can have multiple cast
 * M : 1    => One cast can be in many movie
 */