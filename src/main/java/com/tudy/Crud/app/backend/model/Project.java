package com.tudy.Crud.app.backend.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;



import java.util.HashSet;

import java.util.Set;

@Data
@Entity
@Table(name = "projects")
public class Project {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;
    @Column
    private String title;
    @Column
    private String description;

    @Column
    private String organizer;
    @Column
    private String period;
    @Column
    private String place;

    @JsonIgnore
    @ManyToMany(mappedBy = "assignedProjects")
    private Set<Trainer> trainersSet = new HashSet<>();



}

