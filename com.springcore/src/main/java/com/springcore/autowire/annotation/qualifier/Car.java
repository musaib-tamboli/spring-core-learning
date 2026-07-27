package com.springcore.autowire.annotation.qualifier;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class Car {

    @Autowired
    @Qualifier("dieselEngine")
    private Engine engine;

    public Car() {
        System.out.println("Car Bean Created");
    }

    public void drive() {

        engine.start();

        System.out.println("Car is Running");

    }

}
