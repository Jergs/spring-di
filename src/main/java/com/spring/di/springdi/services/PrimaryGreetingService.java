package com.spring.di.springdi.services;

public class PrimaryGreetingService implements GreetingService {
    @Override
    public String sayGreeting() {
        return "Hello Primary World!";
    }
}
