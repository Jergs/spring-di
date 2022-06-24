package com.spring.di.springdi.pets;

public class CatService implements PetService {

    @Override
    public String sayhello() {
        return "meow";
    }
}
