package ru.LevBayanov.TaskManagement.dao.custom;

import ru.LevBayanov.TaskManagement.entity.ProjectEntity;

import java.util.List;

public interface ProjectRepositoryCustom
{
    List<ProjectEntity> findByName(String name);


}
