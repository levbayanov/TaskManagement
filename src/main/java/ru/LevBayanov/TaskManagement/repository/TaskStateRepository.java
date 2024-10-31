package ru.LevBayanov.TaskManagement.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;
import ru.LevBayanov.TaskManagement.entity.ProjectEntity;
import ru.LevBayanov.TaskManagement.entity.TaskEntity;
import ru.LevBayanov.TaskManagement.entity.TaskStateEntity;

import java.util.List;

@RepositoryRestResource(path = "taskState")
public interface TaskStateRepository extends CrudRepository<TaskStateEntity, Long> {
    List<TaskStateEntity> findByProject(ProjectEntity project);
    List<TaskStateEntity> findByName(String name);
}
