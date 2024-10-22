package ru.LevBayanov.TaskManagement.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

@Setter
@Getter
@Entity
@Table(name = "project")
public class Project {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @Column(unique = true)
    private String name;

    private Instant cratedAt = Instant.now();

    @OneToMany
    @JoinColumn(name = "project_id", referencedColumnName = "id")
    private List<TaskState> taskStates = new ArrayList<>();
}
