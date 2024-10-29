package ru.LevBayanov.TaskManagement.repository;

import org.springframework.data.repository.CrudRepository;
import ru.LevBayanov.TaskManagement.entity.CommentEntity;
import ru.LevBayanov.TaskManagement.entity.TaskEntity;

import java.util.List;

public interface CommentRepository extends CrudRepository<CommentEntity, Long> {
    List<CommentEntity> findByTask(TaskEntity task);


}
