package com.springcore.stereotype.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springcore.stereotype.entity.Student;
import com.springcore.stereotype.repository.StudentRepository;

@Service
public class StudentService {

    private final StudentRepository repository;

    @Autowired
    public StudentService(StudentRepository repository) {

        this.repository = repository;

    }

    public void registerStudent() {

        Student student = new Student(1, "Rahul");

        repository.save(student);

    }

}