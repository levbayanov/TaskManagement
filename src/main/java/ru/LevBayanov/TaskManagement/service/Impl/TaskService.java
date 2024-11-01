package ru.LevBayanov.TaskManagement.service.Impl;

import ru.LevBayanov.TaskManagement.entity.TaskEntity;
import ru.LevBayanov.TaskManagement.entity.TaskStateEntity;

public interface TaskService {
    TaskEntity findByName(String name);
    void addTask(TaskEntity task);
    void addTask(String name, String description, TaskStateEntity taskState);
    void deleteTaskByName(String name);
    void updateTask(String name, String newName, String newDescription, String newTaskState);

}
