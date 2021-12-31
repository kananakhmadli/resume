package com.company.dao.impl;

import com.company.dao.inter.AbstractDAO;
import com.company.dao.inter.SkillDaoInter;
import com.company.entity.Skill;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

public class SkillDaoImpl extends AbstractDAO implements SkillDaoInter {//CountryDaoInter

    @Override
    public List<Skill> getAll() {
        EntityManager em = em();
        String jpql = "select s from Skill s";
        Query query = em.createQuery(jpql, Skill.class);
        return query.getResultList();
    }

}