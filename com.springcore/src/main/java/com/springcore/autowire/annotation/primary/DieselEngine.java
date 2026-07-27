package com.springcore.autowire.annotation.primary;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;


@Component
@Primary
public class DieselEngine implements Engine {

    public DieselEngine() {
        System.out.println("Diesel Engine Bean Created");
    }

    @Override
    public void start() {
        System.out.println("Diesel Engine Started");
    }

}
