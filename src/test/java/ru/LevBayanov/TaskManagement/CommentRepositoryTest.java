package ru.LevBayanov.TaskManagement;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import ru.LevBayanov.TaskManagement.entity.CommentEntity;
import ru.LevBayanov.TaskManagement.entity.TaskEntity;
import ru.LevBayanov.TaskManagement.entity.UserEntity;
import ru.LevBayanov.TaskManagement.repository.CommentRepository;
import ru.LevBayanov.TaskManagement.repository.TaskRepository;
import ru.LevBayanov.TaskManagement.repository.UserRepository;

import java.util.List;
import java.util.UUID;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class CommentRepositoryTest {

    private final CommentRepository commentRepository;
    private final TaskRepository taskRepository;
    private final UserRepository userRepository;
    private TaskEntity task;
    private UserEntity user;
    private CommentEntity comment1;
    private CommentEntity comment2;
    @Autowired
    CommentRepositoryTest(CommentRepository commentRepository, TaskRepository taskRepository, UserRepository userRepository)
    {
        this.commentRepository = commentRepository;
        this.taskRepository = taskRepository;
        this.userRepository = userRepository;
    }

    @BeforeEach
    void setUp() {

        task = new TaskEntity();
        task.setName(UUID.randomUUID().toString());
        task.setDescription(UUID.randomUUID().toString());
        taskRepository.save(task);

        user = new UserEntity();
        user.setName(UUID.randomUUID().toString());
        user.setEmail(UUID.randomUUID().toString());
        userRepository.save(user);

        comment1 = new CommentEntity();
        comment1.setText(UUID.randomUUID().toString());
        comment1.setTask(task);
        comment1.setUser(user);

        comment2 = new CommentEntity();
        comment2.setText(UUID.randomUUID().toString());
        comment2.setTask(task);
        comment2.setUser(user);

        commentRepository.save(comment1);
        commentRepository.save(comment2);
    }

    @Test
    void testFindByTask() {
        List<CommentEntity> foundComments = commentRepository.findByTask(task);
        assertThat(foundComments).isNotEmpty();
        assertEquals(2, foundComments.size());
        assertThat(foundComments).anyMatch(comment -> comment.getText().equals(comment1.getText()));
        assertThat(foundComments).anyMatch(comment -> comment.getText().equals(comment2.getText()));
    }

    @Test
    void testFindByTaskAndUser() {
        List<CommentEntity> foundComments = commentRepository.findByTaskAndUser(task, user);
        assertThat(foundComments).isNotEmpty();
        assertEquals(2, foundComments.size());
        assertThat(foundComments).anyMatch(comment -> comment.getText().equals(comment1.getText()));
        assertThat(foundComments).anyMatch(comment -> comment.getText().equals(comment2.getText()));

    }

}
