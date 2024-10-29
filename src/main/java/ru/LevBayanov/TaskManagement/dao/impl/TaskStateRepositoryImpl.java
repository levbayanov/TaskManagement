package ru.LevBayanov.TaskManagement.dao.impl;

import org.springframework.stereotype.Repository;
import ru.LevBayanov.TaskManagement.dao.custom.TaskStateRepositoryCustom;
import ru.LevBayanov.TaskManagement.entity.TaskEntity;
import ru.LevBayanov.TaskManagement.entity.TaskStateEntity;

import java.util.List;

@Repository
public class TaskStateRepositoryImpl implements TaskStateRepositoryCustom {
    @Override
    public List<TaskStateEntity> findByName(String name) {
        return List.of();
    }

    @Override
    public List<TaskStateEntity> findByProject(String nameProject) {
        return List.of();
    }
}
