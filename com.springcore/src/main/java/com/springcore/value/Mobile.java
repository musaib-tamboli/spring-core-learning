package com.springcore.value;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Mobile {

    @Value("Samsung")
    private String brand;

    @Value("8")
    private int ram;

    @Value("45999.99")
    private double price;

    @Value("true")
    private boolean is5G;

    @Value("A")
    private char grade;

    @Value("123456789012345")
    private long imei;

    public void display() {

        System.out.println("Brand      : " + brand);
        System.out.println("RAM        : " + ram + " GB");
        System.out.println("Price      : ₹" + price);
        System.out.println("5G Support : " + is5G);
        System.out.println("Grade      : " + grade);
        System.out.println("IMEI       : " + imei);

    }
}