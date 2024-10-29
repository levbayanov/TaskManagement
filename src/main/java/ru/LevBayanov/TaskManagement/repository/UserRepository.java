package ru.LevBayanov.TaskManagement.repository;

import org.springframework.data.repository.CrudRepository;
import ru.LevBayanov.TaskManagement.entity.UserEntity;

public interface UserRepository extends CrudRepository<UserEntity, Long> {
}
