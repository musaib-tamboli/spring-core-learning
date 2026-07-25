package com.springcore.lifecycleAnnotation;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {

    public static void main(String[] args) {

        AbstractApplicationContext context = new ClassPathXmlApplicationContext("lifecycleAnnotation.xml");

        context.registerShutdownHook();

        Mobile mobile = (Mobile) context.getBean("mobile");

        System.out.println(mobile);
    }
}