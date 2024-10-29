package ru.LevBayanov.TaskManagement.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import ru.LevBayanov.TaskManagement.entity.TaskStateEntity;

import java.util.List;

public interface TaskStateRepository extends CrudRepository<TaskStateEntity, Long> {
    //List<TaskStateEntity> findTaskStatesByNameProject(String nameProject);

}
