package ru.LevBayanov.TaskManagement.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import ru.LevBayanov.TaskManagement.utility.ReportStatus;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


@Setter
@Getter
@Entity
@Table(name = "report")
public class ReportEntity
{
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private ReportStatus status = ReportStatus.CREATED;

    @Column(nullable = false, columnDefinition = "TEXT")
    private String content;

    @ManyToMany
    @JoinTable(
            name = "report_task",
            joinColumns = @JoinColumn(name = "report_id"),
            inverseJoinColumns = @JoinColumn(name = "task_id")
    )
    private List<TaskEntity> tasks = new ArrayList<>();

    private Long countUsers;

    private Long timeToCountUser;

    private Long timeToCountTask;

    private Long timeToCreatedReport;
}
