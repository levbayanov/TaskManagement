package ru.LevBayanov.TaskManagement.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.Instant;

@Setter
@Getter
@Entity
@Table(name = "comment")
public class CommentEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    private String text;

    private Instant createdAt = Instant.now();

    @ManyToOne
    @JoinColumn(name = "task_id", nullable = false)
    private TaskEntity task;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private UserEntity user;

}
