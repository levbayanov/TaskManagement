package ru.LevBayanov.TaskManagement.custom;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import ru.LevBayanov.TaskManagement.entity.*;
import ru.LevBayanov.TaskManagement.repository.*;

import java.util.UUID;

@SpringBootTest
public class TaskStateRepositoryTest {
    private final CommentRepository commentRepository;
    private final TaskRepository taskRepository;
    private final UserRepository userRepository;
    private final ProjectRepository projectRepository;
    private final TaskStateRepository taskStateRepository;
    private TaskEntity task1;
    private UserEntity user1;
    private TaskStateEntity taskState1;
    private ProjectEntity project;
    private CommentEntity comment1;
    private CommentEntity comment2;
    @Autowired
    TaskStateRepositoryTest(CommentRepository commentRepository,
                       TaskRepository taskRepository,
                       UserRepository userRepository,
                       ProjectRepository projectRepository,
                       TaskStateRepository taskStateRepository)
    {
        this.commentRepository = commentRepository;
        this.taskRepository = taskRepository;
        this.userRepository = userRepository;
        this.projectRepository = projectRepository;
        this.taskStateRepository = taskStateRepository;
    }

    @BeforeEach
    void setUp() {

        project = new ProjectEntity();
        project.setName(UUID.randomUUID().toString());
        projectRepository.save(project);

        user1 = new UserEntity();
        user1.setName(UUID.randomUUID().toString());
        user1.setEmail(UUID.randomUUID().toString());
        userRepository.save(user1);

        taskState1 = new TaskStateEntity();
        taskState1.setName(UUID.randomUUID().toString());
        taskState1.setProject(project);
        taskStateRepository.save(taskState1);

        task1 = new TaskEntity();
        task1.setName(UUID.randomUUID().toString());
        task1.setDescription(UUID.randomUUID().toString());
        task1.setTaskState(taskState1);
        taskRepository.save(task1);

        comment1 = new CommentEntity();
        comment1.setUser(user1);
        comment1.setTask(task1);
        comment1.setText(UUID.randomUUID().toString());
        commentRepository.save(comment1);

        comment2 = new CommentEntity();
        comment2.setUser(user1);
        comment2.setTask(task1);
        comment2.setText(UUID.randomUUID().toString());
        commentRepository.save(comment2);
    }

    @Test
    void testFindByName()
    {
        TaskStateEntity foundTaskState = taskStateRepository.findByName(taskState1.getName()).getFirst();
        Assertions.assertNotNull(foundTaskState);
        Assertions.assertEquals(taskState1.getId(), foundTaskState.getId());
        Assertions.assertEquals(taskState1.getName(), foundTaskState.getName());
    }

    @Test
    void testFindByProject()
    {
        TaskStateEntity foundTaskState = taskStateRepository.findByProject(project).getFirst();
        Assertions.assertNotNull(foundTaskState);
    }
}
