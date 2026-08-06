package com.springcore.value;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Test {

    public static void main(String[] args) {

        ApplicationContext context =
                new AnnotationConfigApplicationContext(AppConfig.class);

//        Mobile mobile = context.getBean(Mobile.class);
        NewMobile mobile = context.getBean(NewMobile.class);

        mobile.display();

    }

}