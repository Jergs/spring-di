package com.spring.di.springdi.controllers;

import com.spring.di.springdi.services.GreetingService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;

@Controller
@AllArgsConstructor
public class MyController {

    private final GreetingService greetingService;

    public String sayHello() {
        return greetingService.sayGreeting();
    }
}
