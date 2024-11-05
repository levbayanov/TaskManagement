package ru.LevBayanov.TaskManagement.entity;

import java.time.Instant;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

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
    @JoinColumn(name = "task_state_id", nullable = false)
    private TaskStateEntity taskState;

//    @ManyToMany(mappedBy = "tasks")
//    private List<ReportEntity> reports = new ArrayList<>();

//    @OneToMany(mappedBy = "task")
//    private List<CommentEntity> comments = new ArrayList<>();

}