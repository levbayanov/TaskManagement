package ru.LevBayanov.TaskManagement.serves;

import ru.LevBayanov.TaskManagement.dao.TaskRepository;
import ru.LevBayanov.TaskManagement.entity.Task;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class TaskServiceImpl implements TaskService{

    private final TaskRepository taskRepository;

    @Autowired
    public TaskServiceImpl(TaskRepository taskRepository)
    {
        this.taskRepository = taskRepository;
    }

    @Override
    public void createTask(Long id, String nameTask) {
        taskRepository.create(new Task(id, nameTask));
    }

    @Override
    public Task fineById(Long id) {
        return taskRepository.read(id);
    }

    @Override
    public void deleteById(Long id) {
        taskRepository.delete(id);
    }

    @Override
    public void updateNameTask(Long id, String newNameTask) {
        taskRepository.update(new Task(id, newNameTask));
    }

}
