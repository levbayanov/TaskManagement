package ru.LevBayanov.TaskManagement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.LevBayanov.TaskManagement.entity.Task;
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
            case "help" -> {
                System.out.println("create     Добавить новою задачу");
                System.out.println("read       Найти задачу");
                System.out.println("delete     Удалить задачу");
                System.out.println("rename     Переименовать задачу");
            }
            case "create" ->
            {
                taskService.createTask(Long.valueOf(cmd[1]), cmd[2]);
                System.out.println("Задача успешно добавлена");
            }
            case "read" ->
            {
                try {
                    Task task = taskService.fineById(Long.valueOf(cmd[1]));
                    System.out.println(task.getNameTask());
                }
                catch (IllegalArgumentException e)
                {
                    System.err.println(e.getMessage());
                }

            }
            case "delete" ->
            {
                try {
                    taskService.deleteById(Long.valueOf(cmd[1]));
                    System.out.println("Задача успешно удалена");
                }
                catch (IllegalArgumentException e)
                {
                    System.err.println(e.getMessage());
                }
            }
            case "rename" ->
            {
                taskService.updateNameTask(Long.valueOf(cmd[1]), String.valueOf(cmd[2]));
            }
            default -> System.out.println("Введена неизвестная команда");
        }
    }
}
