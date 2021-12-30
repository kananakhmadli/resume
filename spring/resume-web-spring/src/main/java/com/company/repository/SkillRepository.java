package com.company.repository;

import com.company.entity.Skill;
import com.company.entity.User;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.ArrayList;
import java.util.List;

@SuppressWarnings({"unchecked", "unused"})
@Repository
public class SkillRepository {

    @PersistenceContext
    private EntityManager em;

    public List<Skill> getAllSkill() {
        String jpql = "SELECT s FROM  Skill s ";
        Query query = em.createQuery(jpql, Skill.class);
        return query.getResultList();
    }

    public void updateCountry(Skill skill) {
        em.merge(skill);
    }

    public void removeSkill(Integer id) {
        Skill u = em.find(Skill.class, id);
        em.remove(u);
    }

    public Skill getSkillBSkillId(Integer id) {
        return em.find(Skill.class, id);
    }


    public List<Skill> getAllSkillByUserId(Integer userId) {
        User user = em.find(User.class, userId);
        List<Skill> skills = new ArrayList<>();
        for (int i = 0; i < user.getUserSkills().size(); i++) {
            skills.add(user.getUserSkills().get(i).getSkill());
        }
        return skills;
    }

}