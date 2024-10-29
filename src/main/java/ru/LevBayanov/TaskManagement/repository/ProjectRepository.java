package ru.LevBayanov.TaskManagement.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import ru.LevBayanov.TaskManagement.entity.ProjectEntity;

import java.util.List;

public interface ProjectRepository extends CrudRepository<ProjectEntity, Long> {

    List<ProjectEntity> findByName(String name);

}
