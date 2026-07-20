package com.springcore.introduction;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {
    public static void main(String[] args) {
        
        // Pass only the filename because it's directly inside src/main/resources
        ApplicationContext context = new ClassPathXmlApplicationContext("config.xml");
        
        // Fetch the bean
        Student student1 = (Student) context.getBean("student1");
        Student student2 = (Student) context.getBean("student2");

        // Print the result
        System.out.println(student1);
        System.out.println(student2);
    }
}