package com.springcore.autowire;

public class Car {

    private Engine engine;

    public Car() {
        System.out.println("Car Object Created");
    }

    public void setEngine(Engine engine) {
        System.out.println("Setter Injection Called");
        this.engine = engine;
    }

    public void start() {
        System.out.println(engine);
        System.out.println("Car Started...");
    }
}	