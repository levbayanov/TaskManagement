package ru.LevBayanov.TaskManagement.repository;

import org.springframework.data.repository.CrudRepository;
import ru.LevBayanov.TaskManagement.entity.ProjectEntity;
import ru.LevBayanov.TaskManagement.entity.TaskEntity;
import ru.LevBayanov.TaskManagement.entity.TaskStateEntity;

import java.util.List;

public interface TaskStateRepository extends CrudRepository<TaskStateEntity, Long> {
    List<TaskStateEntity> findByProject(ProjectEntity project);
    List<TaskStateEntity> findByName(String name);
}
