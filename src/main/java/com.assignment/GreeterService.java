package com.assignment;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import java.time.Clock;
import java.time.LocalTime;

import static org.springframework.util.StringUtils.capitalize;

@Service
@Log4j2
@RequiredArgsConstructor
public class GreeterService {

    private final Clock clock;

    public String getGreetMessage(final String name) {

        final String capitalizedName = capitalize(name.trim());

        log.info("greet method called with name " + capitalizedName);

        if (isMorning()) {
            return "Good morning " + capitalizedName;
        }

        if (isEvening()) {
            return "Good evening " + capitalizedName;
        }

        if (isNight()) {
            return "Good night " + capitalizedName;
        }

    private boolean isMorning() {
        return LocalTime.now(clock)
                .isAfter(LocalTime.parse("06:00:00"))
                && LocalTime.now(clock)
                .isBefore(LocalTime.parse("12:00:00"));
    }

    private boolean isEvening() {
        return LocalTime.now(clock)
                .isAfter(LocalTime.parse("18:00:00"))
                && LocalTime.now(clock)
                .isBefore(LocalTime.parse("22:00:01"));
    }

    private boolean isNight() {
        LocalTime actualTime = LocalTime.now(clock);
        boolean isAfterEvening = actualTime.isAfter(LocalTime.parse("22:00:00"));
        boolean beforeMidnight = actualTime.isBefore(LocalTime.parse("23:59:59"));
        boolean isJustBeforeMidnight = actualTime.equals(LocalTime.parse("23:59:59"));
        boolean isMidnight = actualTime.equals(LocalTime.parse("00:00:00"));
        boolean isAfterMidnight = actualTime.isAfter(LocalTime.parse("00:00:00"));
        boolean beforeMorning = actualTime.isBefore(LocalTime.parse("06:00:01"));
        return (isAfterEvening && beforeMidnight)
                || isJustBeforeMidnight
                || isMidnight
                || (isAfterMidnight && beforeMorning);
    }
}
