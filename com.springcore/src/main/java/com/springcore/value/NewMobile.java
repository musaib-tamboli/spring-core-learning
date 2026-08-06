package com.springcore.value;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
// This Code is to Demonstrate how to read values from the Properties File
@Component
public class NewMobile {

    @Value("${mobile.brand}")
    private String brand;

    @Value("${mobile.ram}")
    private int ram;

    @Value("${mobile.price}")
    private double price;

    @Value("${mobile.is5G}")
    private boolean is5G;

    @Value("${mobile.grade}")
    private char grade;

    @Value("${mobile.imei}")
    private long imei;

    public void display() {

        System.out.println("Brand  : " + brand);
        System.out.println("RAM    : " + ram);
        System.out.println("Price  : " + price);
        System.out.println("5G     : " + is5G);
        System.out.println("Grade  : " + grade);
        System.out.println("IMEI   : " + imei);
    }
}