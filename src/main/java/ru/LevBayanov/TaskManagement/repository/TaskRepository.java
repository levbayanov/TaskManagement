package ru.LevBayanov.TaskManagement.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import ru.LevBayanov.TaskManagement.entity.ProjectEntity;
import ru.LevBayanov.TaskManagement.entity.TaskEntity;
import ru.LevBayanov.TaskManagement.entity.TaskStateEntity;

import java.util.List;

@RepositoryRestResource(path = "task")
public interface TaskRepository extends CrudRepository<TaskEntity, Long> {
    List<TaskEntity> findByTaskState(TaskStateEntity taskState);

    @Query("SELECT t FROM TaskEntity t WHERE t.taskState.project = :project")
    List<TaskEntity> findByProject(@Param("project") ProjectEntity project);

}
