package ru.LevBayanov.TaskManagement.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import ru.LevBayanov.TaskManagement.entity.ProjectEntity;
import ru.LevBayanov.TaskManagement.entity.UserEntity;

import java.util.List;

public interface UserRepository extends CrudRepository<UserEntity, Long> {
    List<UserEntity> findByName(String name);


}
