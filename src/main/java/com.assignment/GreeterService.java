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
}
