package com.springcore.autowire.annotation.autowired;

public class Engine {

    public Engine() {
        System.out.println("Engine Created");
    }

    @Override
    public String toString() {
        return "Petrol Engine";
    }
}