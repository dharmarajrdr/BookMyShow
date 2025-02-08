package com.dharmaraj.bookmyshow.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Getter
@Setter
@Entity
public class Show extends BaseModel {

    @ManyToOne
    private Movie movie;

    private Date startTime;

    private Date endTime;

    @ManyToOne
    private Screen screen;

    @Enumerated(EnumType.ORDINAL)
    @ElementCollection
    private List<Feature> features;
}

/**
 * Show : Movie ( M : 1 )
 * 1 : 1        => One show will stream one movie
 * M : 1        => One movie can be streamed in many shows
 */

/**
 * Show : Screen ( M : 1 )
 * 1 : 1        => One show will be streamed in that particular screen
 * M : 1        => But, that screen can stream many shows
 */
