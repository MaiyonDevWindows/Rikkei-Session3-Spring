package com.maiyon.demo_mvc_model.service;

import com.maiyon.demo_mvc_model.model.Student;

import java.util.List;

public interface IStudentServices {
    List<Student> findAll();
    Student findById(Long studentId);
    void save(Student student);
    void deleteById(Long studentId);
}
