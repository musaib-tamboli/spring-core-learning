package com.springcore.beanscope;

public class Computer {

    private String brand;

    public Computer() {
        System.out.println("Computer Bean Created...");
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public void display() {
        System.out.println("Brand : " + brand);
    }

}