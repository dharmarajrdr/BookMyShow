package com.dharmaraj.bookmyshow.services;

import com.dharmaraj.bookmyshow.custom_exceptions.ScheduleNotFoundException;
import com.dharmaraj.bookmyshow.dtos.AddSchedulerRequestDto;
import com.dharmaraj.bookmyshow.dtos.UpdateSchedulerRequestDto;

public interface SchedulerService {

    public void addScheduler(AddSchedulerRequestDto addSchedulerRequestDto);

    public void updateScheduler(UpdateSchedulerRequestDto updateSchedulerRequestDto) throws ScheduleNotFoundException;
}
