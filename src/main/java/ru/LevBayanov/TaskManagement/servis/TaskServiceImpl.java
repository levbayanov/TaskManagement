package ru.LevBayanov.TaskManagement.servis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.DefaultTransactionDefinition;
import ru.LevBayanov.TaskManagement.entity.CommentEntity;
import ru.LevBayanov.TaskManagement.entity.TaskEntity;
import ru.LevBayanov.TaskManagement.entity.TaskStateEntity;
import ru.LevBayanov.TaskManagement.repository.*;

import java.util.ArrayList;
import java.util.List;

@Service
public class TaskServiceImpl implements TaskService{

    private final TaskRepository taskRepository;
    private final CommentRepository commentRepository;
    private final PlatformTransactionManager transactionManager;

    @Autowired
    public TaskServiceImpl(TaskRepository taskRepository,
                           CommentRepository commentRepository,
                           PlatformTransactionManager transactionManager)
    {
        this.taskRepository = taskRepository;
        this.commentRepository = commentRepository;
        this.transactionManager = transactionManager;
    }


    @Override
    public TaskEntity findByName(String name) {
        List<TaskEntity> fondTask = taskRepository.findByName(name);
            return fondTask.getFirst();
    }

    @Override
    public void addTask(String name, String description, TaskStateEntity taskState) {
        TaskEntity newTask = new TaskEntity();
        newTask.setName(name);
        newTask.setDescription(description);
        newTask.setTaskState(taskState);
        taskRepository.save(newTask);
    }

    @Override
    public void deleteTaskByName(String name) {
        TransactionStatus status = transactionManager.getTransaction(new DefaultTransactionDefinition());
        List<TaskEntity> tasks = taskRepository.findByName(name);
        try {
            for(TaskEntity task: tasks)
            {
                List<CommentEntity> comments = commentRepository.findByTask(task);
                commentRepository.deleteAll(comments);
                taskRepository.delete(task);
            }

            transactionManager.commit(status);
        }
        catch (DataAccessException e)
        {
            transactionManager.rollback(status);
            throw e;
        }


    }
}
