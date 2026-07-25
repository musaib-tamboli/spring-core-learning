package com.springcore.lifeCycleInterface;


import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {

    public static void main(String[] args) {

        AbstractApplicationContext context =
                new ClassPathXmlApplicationContext("lifecycleinterface.xml");

        context.registerShutdownHook();

        Computer computer = (Computer) context.getBean("computer");

        System.out.println(computer);
    }
}