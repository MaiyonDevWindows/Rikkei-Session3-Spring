package com.maiyon.service;

import com.maiyon.model.entity.Student;

import java.util.List;

public interface StudentService {
    List<Student> getAll();
    Student save(Student student);
    Student findById(Long id);
    void delete(Long id);
}
