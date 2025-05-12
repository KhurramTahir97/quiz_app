package com.khurram.quizapp;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class ScheduledTasks {

    @Scheduled(fixedRate = 5000) // runs every 5 seconds
    public void cleanUpTempFiles() {
        System.out.println("Running cleanup task...");
    }

    @Scheduled(cron = "*/10 * * * * *") // after every 10 seconds using cron.
    public void hourlyJob() {
        System.out.println("Cron job triggered.");
    }
}

