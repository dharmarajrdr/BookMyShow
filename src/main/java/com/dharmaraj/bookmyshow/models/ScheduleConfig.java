package com.dharmaraj.bookmyshow.models;

import jakarta.persistence.Entity;
import lombok.Data;

@Entity
@Data
public class ScheduleConfig extends BaseModel {

    private String taskName;

    private String cronExpression;
}
