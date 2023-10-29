package com.assignment;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;

import java.time.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.doReturn;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class GreeterIntegrationTest {

    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate testRestTemplate;

    @MockBean
    private Clock clock;

    @BeforeEach
    public void configureSystemUnderTest() {
        Clock fixedClock = Clock.fixed(Instant.from(ZonedDateTime.parse("2023-10-29T10:00:00Z")), ZoneId.systemDefault());
        doReturn(fixedClock.instant()).when(clock)
                .instant();
        doReturn(fixedClock.getZone()).when(clock)
                .getZone();
    }

    @Test
    public void shouldPrintGreetMessage()
    {
        assertEquals("Good morning John", testRestTemplate.getForObject("http://localhost:" +port + "/greet/john", String.class));
    }
}
