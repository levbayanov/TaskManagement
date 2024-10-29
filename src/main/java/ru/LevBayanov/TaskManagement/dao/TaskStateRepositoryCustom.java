package ru.LevBayanov.TaskManagement.dao;

import ru.LevBayanov.TaskManagement.entity.TaskEntity;

import java.util.List;

public interface TaskStateRepositoryCustom {
    List<TaskEntity> findByProject(String nameProject);

}
