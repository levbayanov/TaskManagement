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
public class ProjectEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    private String name;

    private Instant cratedAt = Instant.now();

    @ManyToMany(mappedBy = "project")
    private List<UserEntity> users = new ArrayList<>();

    @OneToMany(mappedBy = "project")
    private List<TaskStateEntity> taskStates = new ArrayList<>();

}
