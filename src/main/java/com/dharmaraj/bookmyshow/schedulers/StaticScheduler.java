package com.dharmaraj.bookmyshow.schedulers;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
public class StaticScheduler {

    @Scheduled(fixedDelay = 5000)
    public void recursiveAction() {

        System.out.println("Hello");
    }
}
