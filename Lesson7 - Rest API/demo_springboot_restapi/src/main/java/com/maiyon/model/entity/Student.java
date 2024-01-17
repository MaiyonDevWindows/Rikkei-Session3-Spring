package com.maiyon.model.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String fullName;
    private int age;
    private String address;
    @ManyToOne
    // classroom_id của student tham chiếu tới id của classroom.
    @JoinColumn(name = "classroom_id", referencedColumnName = "id")
    private Classroom classroom;
}