package ru.LevBayanov.TaskManagement.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import ru.LevBayanov.TaskManagement.entity.UserEntity;

import java.util.List;

@RepositoryRestResource(path = "users")
public interface UserRepository extends CrudRepository<UserEntity, Long> {
    UserEntity findById(long id);
    UserEntity findByUserName(String name);
    List<UserEntity> findByEmail(String email);
    List<UserEntity> findByFirsNameAndLastName(String FirstName, String lastName);
 }
