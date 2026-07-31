package com.springcore.javaconfig;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    @Bean
    public Laptop laptop() {

        return new Laptop();

    }

    @Bean
    public Student student() {

        return new Student(laptop());

    }

}