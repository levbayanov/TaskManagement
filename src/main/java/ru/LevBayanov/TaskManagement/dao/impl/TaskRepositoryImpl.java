package ru.LevBayanov.TaskManagement.dao.impl;

import ru.LevBayanov.TaskManagement.dao.custom.TaskStateRepositoryCustom;
import ru.LevBayanov.TaskManagement.entity.TaskEntity;

import java.util.List;

public class TaskRepositoryImpl implements TaskStateRepositoryCustom {
    @Override
    public List<TaskEntity> findByProject(String nameProject) {
        return List.of();
    }
}
