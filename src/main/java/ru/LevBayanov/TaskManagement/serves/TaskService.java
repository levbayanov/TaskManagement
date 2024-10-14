package ru.LevBayanov.TaskManagement.serves;

import ru.LevBayanov.TaskManagement.entity.Task;

import java.util.ArrayList;

public interface TaskService {
    void createTask(Long id, String nameTask);
    Task fineById(Long id);
    void deleteById(Long id);
    void updateNameTask(Long id, String newNameTask);

}
