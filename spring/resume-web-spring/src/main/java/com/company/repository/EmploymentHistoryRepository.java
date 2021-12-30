package com.company.repository;

import com.company.entity.EmploymentHistory;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@SuppressWarnings({"unchecked", "unused"})
@Repository
public class EmploymentHistoryRepository {

    @PersistenceContext
    private EntityManager em;

    public List<EmploymentHistory> getEmploymentHistoryByUserId(Integer userId) {
        String jpql = "SELECT eh FROM EmploymentHistory eh WHERE eh.user.id=:id";
        Query query = em.createQuery(jpql, EmploymentHistory.class);
        query.setParameter("id", userId);
        return query.getResultList();
    }

}