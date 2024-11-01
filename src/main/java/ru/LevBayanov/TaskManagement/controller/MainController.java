package ru.LevBayanov.TaskManagement.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import ru.LevBayanov.TaskManagement.entity.TaskEntity;
import ru.LevBayanov.TaskManagement.entity.UserEntity;
import ru.LevBayanov.TaskManagement.repository.ProjectRepository;
import ru.LevBayanov.TaskManagement.repository.TaskRepository;
import ru.LevBayanov.TaskManagement.service.Impl.UserService;
import ru.LevBayanov.TaskManagement.service.UserServiceImpl;

@Controller
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
    public String getRegistration()
    {
        return "registration";
    }

    @PostMapping("/registration")
    @ResponseBody
    public UserEntity registerUser(UserEntity user)
    {
        userService.addUser(user);
        return user;
    }

    @GetMapping("/home")
    public String home()
    {
        return "home";
    }

    @GetMapping("task/list")
    public String taskListView(Model model) {
        // Получаем список всех задач из репозитория
        Iterable<TaskEntity> tasks = taskRepository.findAll();
        // Добавляем задачи в модель
        model.addAttribute("tasks", tasks);
        // Возвращаем имя шаблона для рендеринга
        return "taskList"; // taskList.html
    }
}
