package com.dharmaraj.bookmyshow.dtos;

import lombok.Data;

@Data
public class AddSchedulerRequestDto {

    private String taskName;

    private String cronExpression;
}
