package com.spring.di.springdi.pets;

import com.spring.di.springdi.services.GreetingService;
import com.spring.di.springdi.services.I18nEnglishGreetingService;
import com.spring.di.springdi.services.I18nSpanishGreetingService;

public class PetServiceFactory {

    public PetService getPetService(String type) {
        switch (type) {
            case "dog":
                return new DogService();
            case "cat":
                return new CatService();
            default:
                return new DogService();
        }
    }
}
