package ru.LevBayanov.TaskManagement.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import ru.LevBayanov.TaskManagement.entity.ReportEntity;

@RepositoryRestResource
public interface ReportRepository extends CrudRepository<ReportEntity, Long>
{

}
