package com.springcore.autowire.annotation.qualifier;


import org.springframework.stereotype.Component;

@Component("petrolEngine")
public class PetrolEngine implements Engine {

    public PetrolEngine() {
        System.out.println("Petrol Engine Bean Created");
    }

    @Override
    public void start() {
        System.out.println("Petrol Engine Started");
    }

}
