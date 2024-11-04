package ru.LevBayanov.TaskManagement.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.LevBayanov.TaskManagement.utility.Role;
import ru.LevBayanov.TaskManagement.entity.TaskEntity;
import ru.LevBayanov.TaskManagement.entity.UserEntity;
import ru.LevBayanov.TaskManagement.repository.ProjectRepository;
import ru.LevBayanov.TaskManagement.repository.TaskRepository;
import ru.LevBayanov.TaskManagement.service.UserServiceImpl;

import java.util.Set;

@Controller
@RequestMapping()
public class MainController {

    private final UserServiceImpl userService;
    private final TaskRepository taskRepository;
    private final ProjectRepository projectRepository;

    @Autowired
    public MainController(UserServiceImpl userService,
                          TaskRepository taskRepository,
                          ProjectRepository projectRepository) {
        this.userService = userService;
        this.taskRepository = taskRepository;
        this.projectRepository = projectRepository;
    }

    @GetMapping("/registration")
    public String getRegistration(Model model)
    {
        return "registration";
    }

    @PostMapping("/registration")
    public String registerUser(UserEntity user)
    {
        user.setRoles(Set.of(Role.USER));
        userService.addUser(user);
        return "redirect:/login";
    }

    @GetMapping("/home")
    public String home()
    {
        return "home";
    }

    @GetMapping("/task/list")
    public String taskListView(Model model) {
        Iterable<TaskEntity> tasks = taskRepository.findAll();
        model.addAttribute("tasks", tasks);
        return "taskList";
    }
}
