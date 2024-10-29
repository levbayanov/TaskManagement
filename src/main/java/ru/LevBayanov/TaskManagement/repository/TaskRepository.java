package ru.LevBayanov.TaskManagement.repository;

import org.springframework.data.repository.CrudRepository;
import ru.LevBayanov.TaskManagement.entity.TaskEntity;

public interface TaskRepository extends CrudRepository<TaskEntity, Long> {

}
