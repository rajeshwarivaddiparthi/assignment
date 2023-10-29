package com.assignment;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.Clock;
import java.time.Instant;
import java.time.ZoneId;
import java.time.ZonedDateTime;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

@ExtendWith(MockitoExtension.class)
public class GreeterServiceTest {

    @InjectMocks
    private GreeterService greeterService;

    @BeforeEach
    public void setUp() {
        Clock clock = Clock.fixed(Instant.from(ZonedDateTime.parse("2023-10-29T10:00:00Z")), ZoneId.systemDefault());
        greeterService = new GreeterService(clock);
    }

    @Test
    public void shouldCapitalizeName() {
        String name = greeterService.getGreetMessage("john");
        assertThat(name, is("Good morning John"));
    }
}