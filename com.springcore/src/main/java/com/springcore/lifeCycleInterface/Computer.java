package com.springcore.lifeCycleInterface;


import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

public class Computer implements InitializingBean, DisposableBean {

    private String brand;

    public Computer() {
        System.out.println("1. Computer Object Created");
    }

    public void setBrand(String brand) {
        System.out.println("2. Setter Injection Called");
        this.brand = brand;
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("3. Computer Starting...");
    }

    @Override
    public void destroy() throws Exception {
        System.out.println("5. Computer Shutting Down...");
    }

    @Override
    public String toString() {
        return "Computer Brand : " + brand;
    }
}