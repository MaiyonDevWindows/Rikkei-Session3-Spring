package com.maiyon.service;

import com.maiyon.model.entity.ToDo;

import java.util.List;

public interface ToDoService {
    List<ToDo> getAll();
    ToDo save(ToDo toDo);
    ToDo findById(Long id);
    void delete(Long id);
}
