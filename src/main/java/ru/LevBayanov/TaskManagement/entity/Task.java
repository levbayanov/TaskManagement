package ru.LevBayanov.TaskManagement.entity;

import java.util.ArrayList;

import jakarta.persistence.*;

@Entity
@Table(name = "Tasks")
public class Task {

    @Id
    @GeneratedValue
    private Long id;
    @Column
    private String name;
    private String description;
    private String status; // "Новая", "В процессе", "Завершена"
    private String priority;
    private ArrayList<User> ResponsibleUsers;
    private int createDate;
    private int dueDate;
    private boolean expired;


    public Task(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getPriority() {
        return priority;
    }

    public void setPriority(String priority) {
        this.priority = priority;
    }

    public ArrayList<User> getResponsibleUsers() {
        return ResponsibleUsers;
    }

    public void setResponsibleUsers(ArrayList<User> responsibleUsers) {
        ResponsibleUsers = responsibleUsers;
    }

    public int getDueDate() {
        return dueDate;
    }

    public void setDueDate(int dueDate) {
        this.dueDate = dueDate;
    }

    public boolean isExpired() {
        return expired;
    }

    public void setExpired(boolean expired) {
        this.expired = expired;
    }

    public int getCreateDate() {
        return createDate;
    }

    public void setCreateDate(int createDate) {
        this.createDate = createDate;
    }
}
