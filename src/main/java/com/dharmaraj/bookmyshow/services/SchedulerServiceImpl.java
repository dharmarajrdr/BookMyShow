package com.dharmaraj.bookmyshow.services;

import com.dharmaraj.bookmyshow.custom_exceptions.ScheduleNotFoundException;
import com.dharmaraj.bookmyshow.dtos.AddSchedulerRequestDto;
import com.dharmaraj.bookmyshow.dtos.UpdateSchedulerRequestDto;
import com.dharmaraj.bookmyshow.models.ScheduleConfig;
import com.dharmaraj.bookmyshow.repositories.ScheduleConfigRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SchedulerServiceImpl implements SchedulerService {

    @Autowired
    private ScheduleConfigRepository scheduleConfigRepository;

    @Override
    public void addScheduler(AddSchedulerRequestDto addSchedulerRequestDto) {

        ScheduleConfig scheduleConfig = new ScheduleConfig();
        scheduleConfig.setTaskName(addSchedulerRequestDto.getTaskName());
        scheduleConfig.setCronExpression(addSchedulerRequestDto.getCronExpression());
        scheduleConfigRepository.save(scheduleConfig);
    }

    @Override
    public void updateScheduler(UpdateSchedulerRequestDto updateSchedulerRequestDto) throws ScheduleNotFoundException {

        String taskName = updateSchedulerRequestDto.getTaskName();
        String cronExpression = updateSchedulerRequestDto.getCronExpression();

        ScheduleConfig scheduleConfig = scheduleConfigRepository.findByTaskName(taskName).orElseThrow(() -> new ScheduleNotFoundException(taskName));
        scheduleConfig.setCronExpression(cronExpression);
        scheduleConfigRepository.save(scheduleConfig);
    }
}
