package com.company.dao.impl;

import com.company.entity.User;
import com.company.dao.inter.AbstractDAO;
import com.company.dao.inter.UserDaoInter;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

@Repository("userDao1")
public class UserDaoImpl extends AbstractDAO implements UserDaoInter {//data access object

    @PersistenceContext
    EntityManager em;//dependency injection

    @Override
    public List<User> getAll(String name, String surname, Integer nationalityId) {
        String jpql = "select u from User u where 1=1";

        if (name != null && !name.trim().isEmpty()) {
            jpql += " and u.name like CONCAT(CONCAT('%',:name),'%')";
        }
        if (surname != null && !surname.trim().isEmpty()) {
            jpql += " and u.surname like CONCAT(CONCAT('%',:surname),'%')";
        }
        if (nationalityId != null) {
            jpql += " and u.nationality_id=:nid ";
        }
        Query query = em.createQuery(jpql, User.class);
        if (name != null && !name.trim().isEmpty()) {
            query.setParameter("name", name);
        }
        if (surname != null && !surname.trim().isEmpty()) {
            query.setParameter("surname", surname);
        }
        if (nationalityId != null) {
            query.setParameter("nid", nationalityId);
        }
        return query.getResultList();
    }

    @Override
    public boolean updateUser(User u) {
        em.merge(u);
        return true;
    }

    @Override
    public boolean removeUser(int id) {
        User u = em.find(User.class, id);
        em.remove(u);
        return true;
    }

    @Override
    public User getById(int userId) {
        return em.find(User.class, userId);
    }

    @Override
    public boolean addUser(User u) {
        em.persist(u);
        return true;
    }

    @Override
    public User findByEmailAndPassword(String email, String password) {//jpqa
        Query q = em.createQuery(" select u from User u where u.email=:e and u.password=:p", User.class);

        q.setParameter("e", email);

        q.setParameter("p", password);

        List<User> list = q.getResultList();

        if (list.size() == 1) {
            return list.get(0);
        }
        return null;
    }

    @Override
    public User findByEmail(String email) {
        Query q = em.createQuery("select u from User u where u.email=:e", User.class);

        q.setParameter("e", email);//select u from User u where u.email=:e

        List<User> list = q.getResultList();

        if (list.size() == 1) {
            return list.get(0);
        }
        return null;
    }
}