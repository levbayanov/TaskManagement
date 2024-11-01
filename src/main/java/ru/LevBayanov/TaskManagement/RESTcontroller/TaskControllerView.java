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
@RequestMapping("/html")
public class TaskControllerView {


    @Autowired
    private TaskRepository taskRepository;
    private ProjectRepository projectRepository;

    @GetMapping("/")
    public String taskListView(Model model) {
        // Получаем список всех задач из репозитория
        Iterable<TaskEntity> tasks = taskRepository.findAll();
        // Добавляем задачи в модель
        model.addAttribute("tasks", tasks);
        // Возвращаем имя шаблона для рендеринга
        return "taskList"; // taskList.html
    }
}
