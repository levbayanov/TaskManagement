package ru.LevBayanov.TaskManagement.entity;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
@Table(name = "task")
public class TaskEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @Column(unique = true)
    private String name;

    private String description;

    private Instant createdAt = Instant.now();

    @ManyToOne
    @JoinColumn(name = "task_state_id")
    private TaskStateEntity taskState;

    @OneToMany(mappedBy = "task")
    private List<CommentEntity> comments = new ArrayList<>();

}