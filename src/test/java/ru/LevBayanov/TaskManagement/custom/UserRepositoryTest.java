package ru.LevBayanov.TaskManagement.custom;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import ru.LevBayanov.TaskManagement.entity.UserEntity;
import ru.LevBayanov.TaskManagement.repository.UserRepository;

import java.util.UUID;

@SpringBootTest
public class UserRepositoryTest {

    private final UserRepository userRepository;

    private UserEntity user1;

    @Autowired
    public UserRepositoryTest(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @BeforeEach
    void setUo()
    {
        user1 = new UserEntity();
        user1.setName(UUID.randomUUID().toString());
        user1.setEmail(UUID.randomUUID().toString());
        userRepository.save(user1);
    }

    @Test
    void testFindByName()
    {
        UserEntity foundUser = userRepository.findByName(user1.getName()).getFirst();
        Assertions.assertNotNull(foundUser);
        Assertions.assertEquals(user1.getId(), foundUser.getId());
        Assertions.assertEquals(user1.getName(), foundUser.getName());
    }

}
