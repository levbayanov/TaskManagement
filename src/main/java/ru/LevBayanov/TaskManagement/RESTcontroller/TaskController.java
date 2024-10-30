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

import java.util.List;

@RestController
@RequestMapping("/task")
public class TaskController {

    private final TaskRepository taskRepository;
    private final TaskStateRepository taskStateRepository;
    private final CommentRepository commentRepository;

    @Autowired
    public TaskController(TaskRepository taskRepository,
                          TaskStateRepository taskStateRepository,
                          CommentRepository commentRepository) {
        this.taskRepository = taskRepository;
        this.taskStateRepository = taskStateRepository;
        this.commentRepository = commentRepository;
    }

    @GetMapping("/findByName")
    public ResponseEntity<TaskEntity> getTaskByName(@RequestBody String name) {
        List<TaskEntity> foundTask = taskRepository.findByName(name);

        return ResponseEntity.ok(foundTask.getFirst());
    }

    @PostMapping("create")
    public ResponseEntity<TaskEntity> createTask(@RequestBody String nameTask,
                                                 String description,
                                                 String nameTaskState)
    {
        TaskEntity newTask = new TaskEntity();
        TaskStateEntity taskState = taskStateRepository.findByName(nameTaskState).getFirst();
        newTask.setName(nameTask);
        newTask.setTaskState(taskState);
        newTask.setDescription(description);
        TaskEntity savedTask = taskRepository.save(newTask);
        //return ResponseEntity.status(HttpStatus.CREATED).body(savedTask);
        return ResponseEntity.ok(newTask);
    }

}
