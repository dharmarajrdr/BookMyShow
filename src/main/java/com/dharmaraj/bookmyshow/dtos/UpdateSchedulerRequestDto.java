package com.dharmaraj.bookmyshow.dtos;

import lombok.Data;

@Data
public class UpdateSchedulerRequestDto {

    private String taskName;

    private String cronExpression;
}
