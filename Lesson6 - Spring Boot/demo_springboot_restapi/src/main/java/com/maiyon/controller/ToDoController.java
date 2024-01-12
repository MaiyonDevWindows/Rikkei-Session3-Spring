package com.maiyon.controller;

import com.maiyon.model.entity.ToDo;
import com.maiyon.service.ToDoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/todos")
@CrossOrigin("*")
public class ToDoController {
    @Autowired
    private ToDoService toDoService;
    @GetMapping
    public ResponseEntity<List<ToDo>> getAll(){
        List<ToDo> todos = toDoService.getAll();
        return new ResponseEntity<>(todos, HttpStatus.OK);
    }
    @PostMapping
    public ResponseEntity<ToDo> save(@RequestBody ToDo toDo){
        ToDo toDoNew = toDoService.save(toDo);
        return new ResponseEntity<>(toDoNew, HttpStatus.CREATED);
    }
    @GetMapping("/{id}")
    public ResponseEntity<ToDo> getById(@PathVariable Long id){
        ToDo toDo = toDoService.findById(id);
        return new ResponseEntity<>(toDo, HttpStatus.OK);
    }
    @PutMapping("/{id}")
    public ResponseEntity<ToDo> update(@RequestBody ToDo toDo){
        ToDo toDoUpdate = toDoService.save(toDo);
        return new ResponseEntity<>(toDoUpdate, HttpStatus.OK);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id){
        toDoService.delete(id);
        return new ResponseEntity<>("", HttpStatus.NO_CONTENT);
    }
}
