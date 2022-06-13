package com.spring.di.springdi.controllers;

import com.spring.di.springdi.services.GreetingService;
import lombok.Data;
import lombok.Setter;
import org.springframework.stereotype.Controller;

@Setter
@Controller
public class SetterInjectedController {


    private GreetingService greetingService;

    public String getGreeting() {
        return greetingService.sayGreeting();
    }
}
