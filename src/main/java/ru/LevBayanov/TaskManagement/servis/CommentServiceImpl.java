package ru.LevBayanov.TaskManagement.servis;

import org.springframework.stereotype.Service;
import ru.LevBayanov.TaskManagement.entity.CommentEntity;
import ru.LevBayanov.TaskManagement.entity.TaskEntity;
import ru.LevBayanov.TaskManagement.repository.CommentRepository;
import ru.LevBayanov.TaskManagement.repository.TaskRepository;

import java.util.List;

@Service
public class CommentServiceImpl implements CommentService{
    private final CommentRepository commentRepository;
    private final TaskRepository taskRepository;

    public CommentServiceImpl(CommentRepository commentRepository,
                              TaskRepository taskRepository)
    {
        this.commentRepository = commentRepository;
        this.taskRepository = taskRepository;
    }

    @Override
    public void deleteCommentToTask(TaskEntity task) {
        List<CommentEntity> comments = commentRepository.findByTask(task);
        commentRepository.deleteAll(comments);
        taskRepository.delete(task);
    }

    @Override
    public void moveCommentToTask(TaskEntity task) {

    }
}
