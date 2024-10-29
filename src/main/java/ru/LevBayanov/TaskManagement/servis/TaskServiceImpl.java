package ru.LevBayanov.TaskManagement.servis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.stereotype.Service;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.DefaultTransactionDefinition;
import ru.LevBayanov.TaskManagement.entity.TaskEntity;
import ru.LevBayanov.TaskManagement.repository.CommentRepository;
import ru.LevBayanov.TaskManagement.repository.TaskRepository;
import ru.LevBayanov.TaskManagement.repository.UserRepository;

import java.util.List;

@Service
public class TaskServiceImpl implements TaskService{

    private final TaskRepository taskRepository;
    private final CommentRepository commentRepository;
    private final UserRepository userRepository;
    private final PlatformTransactionManager transactionManager;

    @Autowired
    public TaskServiceImpl(TaskRepository taskRepository, CommentRepository commentRepository, UserRepository userRepository, PlatformTransactionManager transactionManager) {
        this.taskRepository = taskRepository;
        this.commentRepository = commentRepository;
        this.userRepository = userRepository;
        this.transactionManager = transactionManager;
    }

    @Override
    public void deleteTaskByName(String taskName) {
        TransactionStatus status = transactionManager.getTransaction(new
                DefaultTransactionDefinition());



    }
}
