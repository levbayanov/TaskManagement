package ru.LevBayanov.TaskManagement.RESTcontroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.LevBayanov.TaskManagement.entity.TaskEntity;
import ru.LevBayanov.TaskManagement.repository.TaskRepository;

@Controller
@RequestMapping("/custom/task/view")
public class TaskControllerView {

    @Autowired
    private TaskRepository taskRepository;

    @GetMapping("/list")
    public String TaskListVeb(Model model)
    {
        Iterable<TaskEntity> products = taskRepository.findAll();
        model.addAttribute("task", products);
        return "userList";
    }
}
