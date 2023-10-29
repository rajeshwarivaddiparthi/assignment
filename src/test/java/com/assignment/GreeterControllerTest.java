package com.assignment;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class GreeterControllerTest {

    @InjectMocks
    private GreeterController greeterController;

    @Mock
    private GreeterService greeterService;

    @BeforeEach
    public void setUp() {
        greeterController = new GreeterController(greeterService);
    }

    @Test
    public void shouldGreet() {
        when(greeterService.getGreetMessage("john")).thenReturn("Good morning John");
        String name = greeterController.greet("john");
        assertThat(name, is("Good morning John"));
    }
}
