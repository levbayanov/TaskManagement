package ru.LevBayanov.TaskManagement.dao;

import ru.LevBayanov.TaskManagement.entity.TaskEntity;

import java.util.List;

public class TaskStateRepositoryImpl implements TaskStateRepositoryCustom{
    @Override
    public List<TaskEntity> findByProject(String nameProject) {
        return List.of();
    }
}
