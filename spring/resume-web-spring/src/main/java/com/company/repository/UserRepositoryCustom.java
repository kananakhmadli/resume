package com.company.repository;

import com.company.entity.User;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@SuppressWarnings("unchecked")
@Repository("userDao1")
public class UserRepositoryCustom {

    @PersistenceContext
    private EntityManager em;

    public List<User> getAll(String name, String surname, String email) {
        String jpql = "select u from User u where 1=1";

        if (name != null && !name.trim().isEmpty()) {
            jpql += " and u.name like CONCAT(CONCAT('%',:name),'%')";
        }
        if (surname != null && !surname.trim().isEmpty()) {
            jpql += " and u.surname like CONCAT(CONCAT('%',:surname),'%')";
        }
        if (email != null) {
            jpql += " and u.email like CONCAT(CONCAT('%',:email),'%')";
        }
        Query query = em.createQuery(jpql, User.class);
        if (name != null && !name.trim().isEmpty()) {
            query.setParameter("name", name);
        }
        if (surname != null && !surname.trim().isEmpty()) {
            query.setParameter("surname", surname);
        }
        if (email != null) {
            query.setParameter("email", email);
        }
        return query.getResultList();
    }

    public void updateUser(User u) {
        em.merge(u);
    }

    public void removeUser(int id) {
        User u = em.find(User.class, id);
        em.remove(u);
    }

    public User getById(int userId) {
        return em.find(User.class, userId);
    }

    public void addUser(User u) {
        em.persist(u);
    }

    public User findByEmailAndPassword(String email, String password) {
        Query q = em.createQuery(" select u from User u where u.email=:e and u.password=:p", User.class);
        q.setParameter("e", email);
        q.setParameter("p", password);
        List<User> list = q.getResultList();
        return list.stream().findFirst().orElse(null);
    }

    public User findByEmail(String email) {
        Query q = em.createQuery("select u from User u where u.email=:e", User.class);
        q.setParameter("e", email);
        List<User> list = q.getResultList();
        return list.stream().findFirst().orElse(null);
    }

}