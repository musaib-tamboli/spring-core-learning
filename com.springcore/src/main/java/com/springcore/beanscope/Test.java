package com.springcore.beanscope;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {

    public static void main(String[] args) {

        ApplicationContext context =
                new ClassPathXmlApplicationContext("beansScopeConfig.xml");

        Computer c1 = context.getBean("computer", Computer.class);

        Computer c2 = context.getBean("computer", Computer.class);

        c1.display();
        c2.display();

        System.out.println();

        System.out.println("HashCode of c1 : " + c1.hashCode());

        System.out.println("HashCode of c2 : " + c2.hashCode());

        System.out.println();

        System.out.println("Same Object ? " + (c1 == c2));

    }

}