package com.springcore.autowire.annotation.primary;


import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
//@Primary
public class PetrolEngine implements Engine {

    public PetrolEngine() {
        System.out.println("Petrol Engine Bean Created");
    }

    @Override
    public void start() {
        System.out.println("Petrol Engine Started");
    }

}
