package com.maiyon.javasession3.model;

import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class Student{
    private Long studentId;
    private String studentName;
    private Integer age;
    private Boolean gender;
}