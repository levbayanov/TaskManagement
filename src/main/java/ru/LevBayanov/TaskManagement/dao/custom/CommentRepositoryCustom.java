package ru.LevBayanov.TaskManagement.dao.custom;

import ru.LevBayanov.TaskManagement.entity.CommentEntity;
import ru.LevBayanov.TaskManagement.entity.TaskEntity;
import ru.LevBayanov.TaskManagement.entity.UserEntity;

import java.util.List;

public interface CommentRepositoryCustom {
    List<CommentEntity> findByTask(TaskEntity task);
    List<CommentEntity> findByUser(UserEntity user);

}
