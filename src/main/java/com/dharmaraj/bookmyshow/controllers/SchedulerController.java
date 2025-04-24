package com.dharmaraj.bookmyshow.controllers;

import com.dharmaraj.bookmyshow.dtos.*;
import com.dharmaraj.bookmyshow.schedulers.DynamicScheduler;
import com.dharmaraj.bookmyshow.services.SchedulerService;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SchedulerController {

    private SchedulerService schedulerService;
    private DynamicScheduler dynamicScheduler;

    public SchedulerController(SchedulerService schedulerService, DynamicScheduler dynamicScheduler) {
        this.schedulerService = schedulerService;
        this.dynamicScheduler = dynamicScheduler;
    }

    public AddSchedulerResponseDto addScheduler(AddSchedulerRequestDto addSchedulerRequestDto) {
        AddSchedulerResponseDto addSchedulerResponseDto = new AddSchedulerResponseDto();
        try {
            this.schedulerService.addScheduler(addSchedulerRequestDto);
            addSchedulerResponseDto.setMessage("Scheduler added successfully.");
            addSchedulerResponseDto.setResponseStatus(ResponseStatus.SUCCESS);
        } catch (Exception e) {
            addSchedulerResponseDto.setResponseStatus(ResponseStatus.FAILURE);
        }
        return addSchedulerResponseDto;
    }

    public UpdateSchedulerResponseDto updateScheduler(UpdateSchedulerRequestDto updateSchedulerRequestDto) {
        UpdateSchedulerResponseDto updateSchedulerResponseDto = new UpdateSchedulerResponseDto();
        try {
            this.dynamicScheduler.updateScheduler(updateSchedulerRequestDto);
            updateSchedulerResponseDto.setMessage("Scheduler updated successfully.");
            updateSchedulerResponseDto.setResponseStatus(ResponseStatus.SUCCESS);
        } catch (Exception e) {
            updateSchedulerResponseDto.setResponseStatus(ResponseStatus.FAILURE);
        }
        return updateSchedulerResponseDto;
    }
}
