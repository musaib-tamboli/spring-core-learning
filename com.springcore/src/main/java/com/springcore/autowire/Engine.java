package com.springcore.autowire;

public class Engine {

    public Engine() {
        System.out.println("Engine Object Created");
    }

    @Override
    public String toString() {
        return "Engine is Ready";
    }
}