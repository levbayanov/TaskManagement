package ru.LevBayanov.TaskManagement.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import ru.LevBayanov.TaskManagement.entity.UserEntity;

@RepositoryRestResource(path = "users")
public interface UserRepository extends CrudRepository<UserEntity, Long> {
}
