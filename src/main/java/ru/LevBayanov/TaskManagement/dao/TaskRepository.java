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
// здесь логика добавления сущности в userContainer
    }
    @Override
    public Task read(Long id)
    {
        return new Task(id, "12");
// здесь логика получения сущности по id из userContainer
    }
    @Override
    public void update(Task task)
    {
// здесь логика обновления сущности в userContainer
    }
    @Override
    public void delete(Long id)
    {
// здесь логика удаления сущности из userContainer
    }

}
