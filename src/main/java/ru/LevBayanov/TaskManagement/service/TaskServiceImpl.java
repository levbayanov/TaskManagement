package ru.LevBayanov.TaskManagement.service;

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
import ru.LevBayanov.TaskManagement.service.Impl.CommentService;
import ru.LevBayanov.TaskManagement.service.Impl.TaskService;

import java.util.List;

@Service
public class TaskServiceImpl implements TaskService {

    private final TaskRepository taskRepository;
    private final CommentRepository commentRepository;
    private final TaskStateRepository taskStateRepository;
    private final PlatformTransactionManager transactionManager;
    private final CommentService commentService;

    @Autowired
    public TaskServiceImpl(TaskRepository taskRepository,
                           CommentRepository commentRepository,
                           TaskStateRepository taskStateRepository,
                           PlatformTransactionManager transactionManager,
                           CommentService commentService)
    {
        this.taskRepository = taskRepository;
        this.commentRepository = commentRepository;
        this.taskStateRepository = taskStateRepository;
        this.transactionManager = transactionManager;
        this.commentService = commentService;
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
    public void addTask(TaskEntity task) {
        taskRepository.save(task);
    }

    @Override
    public void deleteTaskByName(String name) {
        TransactionStatus status = transactionManager.getTransaction(new DefaultTransactionDefinition());
        List<TaskEntity> tasks = taskRepository.findByName(name);
        try {
            for(TaskEntity task: tasks)
            {
                commentService.deleteCommentToTask(task);
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

    @Override
    public void updateTask(String name, String newName, String newDescription, String newTaskState)
    {

        TaskEntity foundTask = taskRepository.findByName(name).getFirst();
        List<CommentEntity> comments = commentRepository.findByTask(foundTask);
        TaskStateEntity taskState = taskStateRepository.findByName(newTaskState).getFirst();

        TaskEntity updateTask = new TaskEntity();
        updateTask.setName(newName);
        updateTask.setDescription(newDescription);
        updateTask.setTaskState(taskState);
        addTask(updateTask);

        //commentService.moveCommentToTask(comments, updateTask);

        deleteTaskByName(foundTask.getName());
    }
}
