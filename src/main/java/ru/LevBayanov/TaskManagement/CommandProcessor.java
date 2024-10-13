package ru.LevBayanov.TaskManagement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.LevBayanov.TaskManagement.serves.TaskService;

@Component
public class CommandProcessor {
    private final TaskService taskService;

    @Autowired
    public CommandProcessor(TaskService taskService)
    {
        this.taskService = taskService;
    }

    public void processCommand(String input)
    {
        String[] cmd = input.split(" ");
        switch (cmd[0])
        {
            case "create" ->
            {
                taskService.createTask(Long.valueOf(cmd[1]), cmd[2]);
                System.out.println("Задача успешно добавлена");
            }

            default -> System.out.println("Введена неизвестная команда");
        }
    }
}
