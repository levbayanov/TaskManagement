package ru.LevBayanov.TaskManagement.dao.impl;

import ru.LevBayanov.TaskManagement.dao.custom.TaskRepositoryCustom;
import ru.LevBayanov.TaskManagement.dao.custom.TaskStateRepositoryCustom;
import ru.LevBayanov.TaskManagement.entity.TaskEntity;
import ru.LevBayanov.TaskManagement.entity.TaskStateEntity;

import java.util.List;

public class TaskRepositoryImpl implements TaskRepositoryCustom {

    @Override
    public List<TaskEntity> findByName(String name) {
        return List.of();
    }

    @Override
    public List<TaskEntity> findByNameTaskState(TaskStateEntity taskState) {
        return List.of();
    }
}
