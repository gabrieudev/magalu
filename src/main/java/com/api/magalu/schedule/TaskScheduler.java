package com.api.magalu.schedule;

import com.api.magalu.service.CommunicationService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.concurrent.TimeUnit;

@Component
@Slf4j
public class TaskScheduler {

    @Autowired
    private CommunicationService communicationService;

    @Scheduled(fixedDelay = 1, timeUnit = TimeUnit.MINUTES)
    public void checkTasks() {
        LocalDateTime now = LocalDateTime.now();
        log.info("running at {}", now);
        communicationService.send(now);
    }

}
