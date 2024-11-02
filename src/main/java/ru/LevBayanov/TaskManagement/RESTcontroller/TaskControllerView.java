package ru.LevBayanov.TaskManagement.RESTcontroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.LevBayanov.TaskManagement.entity.ProjectEntity;
import ru.LevBayanov.TaskManagement.entity.TaskEntity;
import ru.LevBayanov.TaskManagement.repository.ProjectRepository;
import ru.LevBayanov.TaskManagement.repository.TaskRepository;

@Controller
@RequestMapping()
public class TaskControllerView {


    @Autowired
    private TaskRepository taskRepository;
    private ProjectRepository projectRepository;

    @GetMapping("/task/list")
    public String taskListView(Model model) {
        Iterable<TaskEntity> tasks = taskRepository.findAll();
        model.addAttribute("tasks", tasks);
        return "taskList";
    }
}
