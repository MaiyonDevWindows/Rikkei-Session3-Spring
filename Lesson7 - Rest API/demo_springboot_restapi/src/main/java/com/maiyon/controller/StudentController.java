package com.maiyon.controller;

import com.maiyon.model.entity.Student;
import com.maiyon.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/student")
@CrossOrigin(origins = "*")
public class StudentController {
    @Autowired
    private StudentService studentService;
    @GetMapping
    public ResponseEntity<List<Student>> getAll(){
        List<Student> students = studentService.getAll();
        return new ResponseEntity<>(students, HttpStatus.OK);
    }
    @PostMapping
    public ResponseEntity<Student> save(@RequestBody Student student){
        Student newStudent = studentService.save(student);
        return new ResponseEntity<>(newStudent, HttpStatus.CREATED);
    }
    @GetMapping("/{id}")
    public ResponseEntity<Student> getStudentById(@PathVariable("id") Long id){
        Student findStudent = studentService.findById(id);
        return new ResponseEntity<>(findStudent, HttpStatus.OK);
    }
    @PutMapping("/{id}")
    public ResponseEntity<Student> update(@PathVariable("id") Long id, @RequestBody Student student){
        student.setId(id);
        Student updateStudent = studentService.save(student);
        return new ResponseEntity<>(updateStudent, HttpStatus.OK);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") Long id){
        studentService.delete(id);
        return new ResponseEntity<>("", HttpStatus.NO_CONTENT);
    }
}