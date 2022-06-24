package com.spring.di.springdi.controllers;

import com.spring.di.springdi.pets.PetService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;

@Controller
@AllArgsConstructor
public class PetController {

    private final PetService petService;

    public String whichIsTheBestPet() {
        return petService.sayhello();
    }
}
