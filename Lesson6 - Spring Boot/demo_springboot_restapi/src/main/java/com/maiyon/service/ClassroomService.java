package com.maiyon.service;

import com.maiyon.model.entity.Classroom;

import java.util.List;

public interface ClassroomService {
    List<Classroom> getAll();
    Classroom save(Classroom classroom);
    Classroom findById(Long id);
    void delete(Long id);
}
