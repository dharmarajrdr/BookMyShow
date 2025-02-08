package com.dharmaraj.bookmyshow.models;

import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@MappedSuperclass
public class BaseModel {

    private long id;
    private Date createdAt;
    private Date lastModifiedAt;
}
