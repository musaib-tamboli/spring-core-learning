package com.springcore.stereotype.repository;

import org.springframework.stereotype.Repository;

import com.springcore.stereotype.entity.Student;

@Repository
public class StudentRepository {

    public void save(Student student) {

        System.out.println("Saving Student into Database...");

        System.out.println("Student Name : " + student.getName());

    }

}