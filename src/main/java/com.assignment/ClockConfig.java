package com.assignment;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.Clock;

import static java.time.Clock.systemDefaultZone;

@Configuration
public class ClockConfig {

    @Bean
    public Clock defaultClock() {
        return systemDefaultZone();
    }
}
