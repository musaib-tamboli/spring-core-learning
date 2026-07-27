package com.springcore.autowire.annotation.autowired;

import org.springframework.beans.factory.annotation.Autowired;

public class Car {

    @Autowired
    private Engine engine;

    public Car() {
        System.out.println("Car Created");
    }

    public void start() {
        System.out.println(engine);
        System.out.println("Car Started");
    }
}