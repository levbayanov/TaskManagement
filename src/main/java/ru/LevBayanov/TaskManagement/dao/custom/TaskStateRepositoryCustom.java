package ru.LevBayanov.TaskManagement.dao.custom;

import ru.LevBayanov.TaskManagement.entity.TaskEntity;
import ru.LevBayanov.TaskManagement.entity.TaskStateEntity;

import java.util.List;

public interface TaskStateRepositoryCustom {
    List<TaskStateEntity> findByName(String name);
    List<TaskStateEntity> findByProject(String nameProject);

}
