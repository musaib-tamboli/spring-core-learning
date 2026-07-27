package com.springcore.autowire.annotation.autowired;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {

    public static void main(String[] args) {

        ApplicationContext context =
                new ClassPathXmlApplicationContext("autowireAnnotation.xml");

        Car car = context.getBean("car", Car.class);

        car.start();
    }
}