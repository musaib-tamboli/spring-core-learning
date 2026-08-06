package com.springcore.stereotype;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.springcore.stereotype.config.AppConfig;
import com.springcore.stereotype.controller.StudentController;

public class Test {

    public static void main(String[] args) {

        ApplicationContext context =
                new AnnotationConfigApplicationContext(AppConfig.class);

        StudentController controller =
                context.getBean(StudentController.class);

        controller.register();

    }

}