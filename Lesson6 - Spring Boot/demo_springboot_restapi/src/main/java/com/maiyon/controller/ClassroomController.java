package com.maiyon.controller;

import com.maiyon.model.entity.Classroom;
import com.maiyon.service.ClassroomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/classroom")
@CrossOrigin(origins = "*")
public class ClassroomController {
    @Autowired
    private ClassroomService classroomService;
    @GetMapping
    public ResponseEntity<List<Classroom>> getAll(){
        List<Classroom> classrooms = classroomService.getAll();
        return new ResponseEntity<>(classrooms, HttpStatus.OK);
    }
    @PostMapping
    public ResponseEntity<Classroom> save(@RequestBody Classroom classroom){
        Classroom newClass = classroomService.save(classroom);
        return new ResponseEntity<>(newClass, HttpStatus.CREATED);
    }
    @GetMapping("/{id}")
    public ResponseEntity<Classroom> getClassroomById(@PathVariable("id") Long id){
        Classroom findClass = classroomService.findById(id);
        return new ResponseEntity<>(findClass, HttpStatus.OK);
    }
    @PutMapping("/{id}")
    public ResponseEntity<Classroom> update(@PathVariable("id") Long id, @RequestBody Classroom classroom){
        classroom.setId(id);
        Classroom updateClass = classroomService.save(classroom);
        return new ResponseEntity<>(updateClass, HttpStatus.OK);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") Long id){
        classroomService.delete(id);
        return new ResponseEntity<>("", HttpStatus.NO_CONTENT);
    }
}
