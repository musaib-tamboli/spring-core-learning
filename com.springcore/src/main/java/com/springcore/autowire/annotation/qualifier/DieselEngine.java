package com.springcore.autowire.annotation.qualifier;

import org.springframework.stereotype.Component;


@Component("dieselEngine")
public class DieselEngine implements Engine {

    public DieselEngine() {
        System.out.println("Diesel Engine Bean Created");
    }

    @Override
    public void start() {
        System.out.println("Diesel Engine Started");
    }

}
