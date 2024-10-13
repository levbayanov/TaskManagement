package ru.LevBayanov.TaskManagement.entity;

public class Task {
    private Long id;
    private String nameTask;

    public Task(Long id, String nameTask)
    {
        this.id = id;
        this.nameTask = nameTask;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNameTask() {
        return nameTask;
    }

    public void setNameTask(String nameTask) {
        this.nameTask = nameTask;
    }
}
