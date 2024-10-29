package ru.LevBayanov.TaskManagement.dao.impl;

import jakarta.persistence.EntityManager;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ru.LevBayanov.TaskManagement.dao.custom.ProjectRepositoryCustom;
import ru.LevBayanov.TaskManagement.entity.ProjectEntity;

import java.util.List;

@Repository
public class ProjectRepositoryImpl implements ProjectRepositoryCustom {

    private final EntityManager entityManager;

    @Autowired
    public ProjectRepositoryImpl(EntityManager entityManager)
    {
        this.entityManager = entityManager;
    }

    @Override
    public List<ProjectEntity> findByName(String name) {
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<ProjectEntity> cq = cb.createQuery(ProjectEntity.class);

        Root<ProjectEntity> projectRoot = cq.from(ProjectEntity.class);
        Predicate namePredicate = cb.equal(projectRoot.get("name"), name);

        cq.select(projectRoot).where(namePredicate);

        return entityManager.createQuery(cq).getResultList();
    }
}
