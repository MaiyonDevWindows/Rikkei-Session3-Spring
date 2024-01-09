package com.maiyon.javasession3.service;

import com.maiyon.javasession3.model.Student;

import java.util.List;

public interface IStudentServices {
    List<Student> findAll();
    Student findById(Long studentId);
    void save(Student student);
    void deleteById(Long studentId);
}
