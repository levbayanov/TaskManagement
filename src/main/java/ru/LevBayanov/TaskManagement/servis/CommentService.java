package ru.LevBayanov.TaskManagement.servis;

import ru.LevBayanov.TaskManagement.entity.TaskEntity;

public interface CommentService {
    void deleteCommentToTask(TaskEntity task);
    void moveCommentToTask(TaskEntity task);
}
