package com.maiyon.service;

import com.maiyon.model.entity.Classroom;
import com.maiyon.repository.ClassroomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClassroomServiceImp implements ClassroomService{
    @Autowired
    private ClassroomRepository classroomRepository;
    @Override
    public List<Classroom> getAll() {
        return classroomRepository.findAll();
    }

    @Override
    public Classroom save(Classroom classroom) {
        return classroomRepository.save(classroom);
    }

    @Override
    public Classroom findById(Long id) {
        return classroomRepository.findById(id).orElse(null);
    }

    @Override
    public void delete(Long id) {
        classroomRepository.deleteById(id);
    }
}
