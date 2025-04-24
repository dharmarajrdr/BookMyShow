package com.dharmaraj.bookmyshow.models;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Rating extends BaseModel {
    
    @ManyToOne
    private User user;

    @ManyToOne
    private Movie movie;

    private int rating;
}
