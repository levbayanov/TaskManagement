package ru.LevBayanov.TaskManagement.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import ru.LevBayanov.TaskManagement.entity.CommentEntity;
import ru.LevBayanov.TaskManagement.entity.TaskEntity;
import ru.LevBayanov.TaskManagement.entity.UserEntity;

import java.util.List;

@RepositoryRestResource(path = "comment")
public interface CommentRepository extends CrudRepository<CommentEntity, Long> {
    List<CommentEntity> findByTask(TaskEntity task);
    List<CommentEntity> findByTaskAndUser(TaskEntity task, UserEntity user);

}
