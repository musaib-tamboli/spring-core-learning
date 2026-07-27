package com.springcore.lifecycleAnnotation;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;

public class Mobile {

    private String brand;

    public Mobile() {
        System.out.println("1. Mobile Object Created"); 
    }

    public void setBrand(String brand) {
        System.out.println("2. Setter Injection Called");
        this.brand = brand;
    }

    @PostConstruct
    public void start() {
        System.out.println("3. Mobile Starting...");
    }

    @PreDestroy
    public void shutdown() {
        System.out.println("5. Mobile Shutting Down...");
    }

    @Override
    public String toString() {
        return "Mobile Brand : " + brand;
    }
}