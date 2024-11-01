package ru.LevBayanov.TaskManagement.RESTcontroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.LevBayanov.TaskManagement.entity.CommentEntity;
import ru.LevBayanov.TaskManagement.entity.TaskEntity;
import ru.LevBayanov.TaskManagement.entity.TaskStateEntity;
import ru.LevBayanov.TaskManagement.repository.CommentRepository;
import ru.LevBayanov.TaskManagement.repository.TaskRepository;
import ru.LevBayanov.TaskManagement.repository.TaskStateRepository;
import ru.LevBayanov.TaskManagement.servis.TaskService;
import ru.LevBayanov.TaskManagement.servis.TaskServiceImpl;

import java.util.List;

@RestController
@RequestMapping("/task")
public class TaskController {

    private final TaskStateRepository taskStateRepository;
    private final TaskServiceImpl taskService;
    @Autowired
    public TaskController(TaskStateRepository taskStateRepository,
                          TaskServiceImpl taskService) {
        this.taskStateRepository = taskStateRepository;
        this.taskService = taskService;
    }

    @GetMapping("findByName")
    public TaskEntity findByName(@RequestParam String name)
    {
        return taskService.findByName(name);
    }

    @PostMapping("addTask")
    public void addTask(@RequestParam
                            String nameTask,
                            String description,
                            String nameTaskState)
    {
        TaskStateEntity taskState = taskStateRepository.findByName(nameTaskState).getFirst();
        taskService.addTask(nameTask, description, taskState);

    }

    @DeleteMapping("deleteTask")
    public void deleteTask(@RequestParam String name)
    {
        taskService.deleteTaskByName(name);
    }

    @PutMapping("PutTask")
    public void updateTask(@RequestParam String oldName, String newName,
                           String newDescription, String newTaskState)
    {
        taskService.updateTask(oldName, newName, newDescription, newTaskState);
    }

}
