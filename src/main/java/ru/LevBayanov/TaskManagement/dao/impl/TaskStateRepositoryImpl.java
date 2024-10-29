package ru.LevBayanov.TaskManagement.dao.impl;

import org.springframework.stereotype.Repository;
import ru.LevBayanov.TaskManagement.dao.custom.TaskStateRepositoryCustom;
import ru.LevBayanov.TaskManagement.entity.TaskEntity;

import java.util.List;

@Repository
public class TaskStateRepositoryImpl implements TaskStateRepositoryCustom {
    @Override
    public List<TaskEntity> findByProject(String nameProject) {
        return List.of();
    }
}
