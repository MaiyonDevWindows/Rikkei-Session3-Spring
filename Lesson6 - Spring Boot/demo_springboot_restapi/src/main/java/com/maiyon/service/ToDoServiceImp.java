package com.maiyon.service;

import com.maiyon.model.entity.ToDo;
import com.maiyon.repository.ToDoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ToDoServiceImp implements ToDoService {
    @Autowired
    private ToDoRepository toDoRepository;
    @Override
    public List<ToDo> getAll() {
        return toDoRepository.findAll();
    }

    @Override
    public ToDo save(ToDo toDo) {
        return toDoRepository.save(toDo);
    }

    @Override
    public ToDo findById(Long id) {
        return toDoRepository.findById(id).orElse(null);
    }

    @Override
    public void delete(Long id) {
        toDoRepository.deleteById(id);
    }
}
