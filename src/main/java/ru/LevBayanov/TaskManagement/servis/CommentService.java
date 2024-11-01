package ru.LevBayanov.TaskManagement.servis;

import ru.LevBayanov.TaskManagement.entity.CommentEntity;
import ru.LevBayanov.TaskManagement.entity.TaskEntity;

import java.util.List;

public interface CommentService {
    void deleteCommentToTask(TaskEntity task);
    void moveCommentToTask(List<CommentEntity>comments,  TaskEntity task);
}
