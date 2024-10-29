package ru.LevBayanov.TaskManagement.dao.custom;

import ru.LevBayanov.TaskManagement.entity.ProjectEntity;
import ru.LevBayanov.TaskManagement.entity.UserEntity;

import java.util.List;

public interface UserRepositoryCustom {
    List<UserEntity> findByName(String name);
    List<UserEntity> findByProject(ProjectEntity project);
}
