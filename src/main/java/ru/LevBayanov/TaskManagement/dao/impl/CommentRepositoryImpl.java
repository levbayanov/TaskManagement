package ru.LevBayanov.TaskManagement.dao.impl;

import ru.LevBayanov.TaskManagement.dao.custom.CommentRepositoryCustom;
import ru.LevBayanov.TaskManagement.entity.CommentEntity;
import ru.LevBayanov.TaskManagement.entity.TaskEntity;
import ru.LevBayanov.TaskManagement.entity.UserEntity;

import java.util.List;

public class CommentRepositoryImpl implements CommentRepositoryCustom {
    @Override
    public List<CommentEntity> findByTask(TaskEntity task) {
        return List.of();
    }

    @Override
    public List<CommentEntity> findByUser(UserEntity user) {
        return List.of();
    }
}
