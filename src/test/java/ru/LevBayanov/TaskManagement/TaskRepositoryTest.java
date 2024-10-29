package ru.LevBayanov.TaskManagement;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import ru.LevBayanov.TaskManagement.entity.*;
import ru.LevBayanov.TaskManagement.repository.*;

import java.util.List;
import java.util.UUID;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

@SpringBootTest
public class TaskRepositoryTest {

    private final CommentRepository commentRepository;
    private final TaskRepository taskRepository;
    private final UserRepository userRepository;
    private final ProjectRepository projectRepository;
    private final TaskStateRepository taskStateRepository;
    private TaskEntity task1;
    private UserEntity user1;
    private TaskStateEntity taskState;
    private ProjectEntity project;
    private CommentEntity comment1;
    private CommentEntity comment2;
    @Autowired
    TaskRepositoryTest(CommentRepository commentRepository,
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

        taskState = new TaskStateEntity();
        taskState.setName(UUID.randomUUID().toString());
        taskState.setProject(project);
        taskStateRepository.save(taskState);

        task1 = new TaskEntity();
        task1.setName(UUID.randomUUID().toString());
        task1.setDescription(UUID.randomUUID().toString());
        task1.setTaskState(taskState);
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
        List<TaskEntity> foundTasks = taskRepository.findByName(task1.getName());

        Assertions.assertFalse(foundTasks.isEmpty());
        assertThat(foundTasks).anyMatch(task -> task.getName().equals(task1.getName()));
        assertThat(foundTasks).anyMatch(task -> task.getId().equals(task1.getId()));
    }

    @Test
    void testFindByTaskState()
    {
        List<TaskEntity> foundTasks = taskRepository.findByTaskState(taskState);

        Assertions.assertFalse(foundTasks.isEmpty());
        assertThat(foundTasks).anyMatch(task -> task.getName().equals(task1.getName()));
        assertThat(foundTasks).anyMatch(task -> task.getId().equals(task1.getId()));
    }

    @Test
    void testFindByProject()
    {
        List<TaskEntity> foundTasks = taskRepository.findByProject(project);

        Assertions.assertFalse(foundTasks.isEmpty());
        assertThat(foundTasks).anyMatch(task -> task.getName().equals(task1.getName()));
        assertThat(foundTasks).anyMatch(task -> task.getId().equals(task1.getId()));
    }

}
