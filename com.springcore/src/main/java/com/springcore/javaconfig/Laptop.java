package com.springcore.javaconfig;

public class Laptop {

    public Laptop() {
        System.out.println("Laptop Object Created");
        System.out.println("Laptop Created : "
                + this.hashCode());
    }

    public void compile() {
        System.out.println("Compiling Java Program...");
    }

}