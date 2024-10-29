package ru.LevBayanov.TaskManagement.dao.custom;

import ru.LevBayanov.TaskManagement.entity.TaskEntity;
import ru.LevBayanov.TaskManagement.entity.TaskStateEntity;

import java.util.List;

public interface TaskRepositoryCustom {
    List<TaskEntity> findByName(String name);
    List<TaskEntity> findByNameTaskState(TaskStateEntity taskState);
}
