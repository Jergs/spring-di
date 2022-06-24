package com.spring.di.springdi.services;

public class ConstructorGreetingService implements GreetingService {
    @Override
    public String sayGreeting() {
        return "Hello Constructor World!";
    }
}
