package com.assignment;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class GreeterController {

    private final GreeterService greeterService;

    @GetMapping(value = "/greet/{name}")
    public String greet(@PathVariable("name") final String name) {

        return greeterService.getGreetMessage(name);

    }
}
