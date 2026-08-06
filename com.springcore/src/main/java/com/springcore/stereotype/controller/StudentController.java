package com.springcore.stereotype.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.springcore.stereotype.service.StudentService;

@Component
public class StudentController {

    private final StudentService service;

    @Autowired
    public StudentController(StudentService service) {

        this.service = service;

    }

    public void register() {

        System.out.println("Registration Request Received");

        service.registerStudent();

    }

}