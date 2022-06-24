package com.spring.di.springdi.pets;

public class DogService implements PetService {

    @Override
    public String sayhello() {
        return "bark";
    }
}
