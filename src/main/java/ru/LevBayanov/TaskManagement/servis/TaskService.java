package ru.LevBayanov.TaskManagement.servis;

import ru.LevBayanov.TaskManagement.entity.TaskEntity;
import ru.LevBayanov.TaskManagement.entity.TaskStateEntity;

import java.util.List;

public interface TaskService {
    TaskEntity findByName(String name);
    void addTask(String name, String description, TaskStateEntity taskState);
    void deleteTaskByName(String name);

}
