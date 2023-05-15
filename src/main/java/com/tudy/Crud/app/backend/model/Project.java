package com.tudy.Crud.app.backend.model;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.DialectOverride;

import java.util.HashSet;
import java.util.List;
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

//    @OneToMany(mappedBy = "project")
//    private List<Trainer> trainers;



}

