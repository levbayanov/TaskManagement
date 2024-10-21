package ru.LevBayanov.TaskManagement.entity;

import java.time.Instant;
import java.util.ArrayList;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
@Table(name = "Task")
public class Task {
    @Id
    @GeneratedValue
    private Long id;

    @Column(unique = true)
    private String name;

    private String description;

    private Instant createAt = Instant.now();

}