package ru.LevBayanov.TaskManagement.dao.impl;

import jakarta.persistence.EntityManager;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Join;
import jakarta.persistence.criteria.Root;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ru.LevBayanov.TaskManagement.dao.custom.UserRepositoryCustom;
import ru.LevBayanov.TaskManagement.entity.ProjectEntity;
import ru.LevBayanov.TaskManagement.entity.UserEntity;

import java.util.List;

@Repository
public class UserRepositoryImpl implements UserRepositoryCustom {
    private final EntityManager entityManager;

    @Autowired
    public UserRepositoryImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public List<UserEntity> findByName(String name) {
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<UserEntity> criteriaQuery = criteriaBuilder.createQuery(UserEntity.class);
        Root<UserEntity> userRoot = criteriaQuery.from(UserEntity.class);

        criteriaQuery.select(userRoot).where(criteriaBuilder.equal(userRoot.get("name"), name));

        return entityManager.createQuery(criteriaQuery).getResultList();
    }

    @Override
    public List<UserEntity> findByProject(ProjectEntity project) {
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<UserEntity> criteriaQuery = criteriaBuilder.createQuery(UserEntity.class);
        Root<UserEntity> userRoot = criteriaQuery.from(UserEntity.class);

        Join<UserEntity, ProjectEntity> projectJoin = userRoot.join("projects");

        criteriaQuery.select(userRoot).where(criteriaBuilder.equal(projectJoin, project));

        return entityManager.createQuery(criteriaQuery).getResultList();
    }
}
