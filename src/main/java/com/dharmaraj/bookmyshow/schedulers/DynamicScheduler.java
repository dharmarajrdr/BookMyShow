package com.dharmaraj.bookmyshow.schedulers;

import com.dharmaraj.bookmyshow.custom_exceptions.ScheduleNotFoundException;
import com.dharmaraj.bookmyshow.dtos.UpdateSchedulerRequestDto;
import com.dharmaraj.bookmyshow.models.User;
import com.dharmaraj.bookmyshow.repositories.ScheduleConfigRepository;
import com.dharmaraj.bookmyshow.services.NotifyPromotionalAdvertisementService;
import com.dharmaraj.bookmyshow.services.SchedulerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.concurrent.ThreadPoolTaskScheduler;
import org.springframework.scheduling.support.CronTrigger;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.ScheduledFuture;

/**
 * This service is specifically for deliver the promotional messages in custom time.
 * Example: Every week, Every month,..
 * Instead of hardcoding the cron expression in code, we can store the same expression in DB.
 * Trigger an API to update the schedule.
 */
@Service
public class DynamicScheduler {

    private SchedulerService schedulerService;
    private ScheduleConfigRepository scheduleConfigRepository;
    private NotifyPromotionalAdvertisementService notifyPromotionalAdvertisementService;

    private ScheduledFuture<?> scheduledFuture;
    private final ThreadPoolTaskScheduler threadPoolTaskScheduler = new ThreadPoolTaskScheduler();

    public DynamicScheduler() {
        threadPoolTaskScheduler.initialize();
    }

    @Autowired
    public DynamicScheduler(SchedulerService schedulerService, ScheduleConfigRepository scheduleConfigRepository, NotifyPromotionalAdvertisementService notifyPromotionalAdvertisementService) {

        this.schedulerService = schedulerService;
        this.scheduleConfigRepository = scheduleConfigRepository;
        this.notifyPromotionalAdvertisementService = notifyPromotionalAdvertisementService;
    }

    public void updateScheduler(UpdateSchedulerRequestDto updateSchedulerRequestDto) throws ScheduleNotFoundException {

        this.schedulerService.updateScheduler(updateSchedulerRequestDto);

        restartScheduler(updateSchedulerRequestDto.getCronExpression());
    }

    /**
     * Stop the existing schedule and start the schedule in custom time.
     *
     * @param cronExpression
     */
    // @Scheduled(cron = "0 0 3 * * *")    // Hardcoded expression
    private void restartScheduler(String cronExpression) {
        if (scheduledFuture != null) {
            scheduledFuture.cancel(false);  // cancel the existing schedule
        }
        List<User> users = List.of(
                new User("Dharmaraj R", "dharmaraj.171215@gmail.com", "6383392245", "*****")
        );
        Runnable taskToPerform = () -> {
            notifyPromotionalAdvertisementService.notifyPromotionalAdvertisement("Book your tickets for 'Jersey' movie.", users);
        };
        scheduledFuture = threadPoolTaskScheduler.schedule(taskToPerform, new CronTrigger(cronExpression)); // (Runnable, Trigger)
    }
}
