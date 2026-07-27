package com.springcore.autowire.annotation.primary;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class Car {

    @Autowired
    private Engine engine;

    public Car() {
        System.out.println("Car Bean Created");
    }

    public void drive() {

        engine.start();

        System.out.println("Car is Running");

    }

}
