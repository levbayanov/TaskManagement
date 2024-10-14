package ru.LevBayanov.TaskManagement.dao;

import ru.LevBayanov.TaskManagement.entity.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class TaskRepository implements CrudRepository<Task, Long>{

    private final List<Task> taskContainer;

    @Autowired
    public TaskRepository(List<Task> taskContainer)
    {
        this.taskContainer = taskContainer;
    }
    @Override
    public void create(Task task)
    {
        taskContainer.add(task);
    }
    @Override
    public Task read(Long id) throws IllegalArgumentException {
        return taskContainer.stream()
                .filter(task -> task.getId().equals(id))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Задача с ID " + id + " не найдена"));
    }
    @Override
    public void update(Task task)
    {
        for(int i = 0; i < taskContainer.size(); i++)
        {
            if(taskContainer.get(i).getId().equals(task.getId()))
            {
                taskContainer.set(i, task);
            }
        }
    }
    @Override
    public void delete(Long id)
    {
        taskContainer.remove(read(id));

    }

}
