package ru.LevBayanov.TaskManagement.dao.impl;


import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;
import org.springframework.stereotype.Repository;
import ru.LevBayanov.TaskManagement.dao.custom.CommentRepositoryCustom;
import ru.LevBayanov.TaskManagement.entity.CommentEntity;
import ru.LevBayanov.TaskManagement.entity.TaskEntity;
import ru.LevBayanov.TaskManagement.entity.UserEntity;

import java.util.List;

@Repository
public class CommentRepositoryImpl implements CommentRepositoryCustom {

    @PersistenceContext
    private EntityManager entityManager;


    @Override
    public List<CommentEntity> findByUser(UserEntity user) {
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<CommentEntity> criteriaQuery = criteriaBuilder.createQuery(CommentEntity.class);
        Root<CommentEntity> commentRoot = criteriaQuery.from(CommentEntity.class);

        criteriaQuery.select(commentRoot)
                .where(criteriaBuilder.equal(commentRoot.get("user"), user));

        return entityManager.createQuery(criteriaQuery).getResultList();
    }
}
