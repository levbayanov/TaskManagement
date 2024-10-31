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

    private final TaskRepository taskRepository;
    private final TaskStateRepository taskStateRepository;
    private final CommentRepository commentRepository;
    private final TaskServiceImpl taskService;
    @Autowired
    public TaskController(TaskRepository taskRepository,
                          TaskStateRepository taskStateRepository,
                          CommentRepository commentRepository,
                          TaskServiceImpl taskService) {
        this.taskRepository = taskRepository;
        this.taskStateRepository = taskStateRepository;
        this.commentRepository = commentRepository;
        this.taskService = taskService;
    }

//    @GetMapping("/findByName")
//    public ResponseEntity<TaskEntity> getTaskByName(@RequestBody String name) {
//        List<TaskEntity> foundTask = taskRepository.findByName(name);
//
//        return ResponseEntity.ok(foundTask.getFirst());
//    }

    @GetMapping("findByName")
    public TaskEntity findByName(@RequestParam String name)
    {
        return taskService.findByName(name);
    }

    @PostMapping("addTask")
    public void createTask(@RequestParam String nameTask,
                                                 String description,
                                                 String nameTaskState)
    {
        TaskStateEntity taskState = taskStateRepository.findByName(nameTaskState).getFirst();
        taskService.addTask(nameTask, description, taskState);

    }

}
