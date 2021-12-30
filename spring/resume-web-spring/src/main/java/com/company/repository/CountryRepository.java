package com.company.repository;

import com.company.entity.Country;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@SuppressWarnings({"unchecked", "unused"})
@Repository
public class CountryRepository {

    @PersistenceContext
    private EntityManager em;

    public List<Country> getAllCountry() {
        String jpql = "SELECT c FROM  Country c ";
        Query query = em.createQuery(jpql, Country.class);
        return query.getResultList();
    }

    public void updateCountry(Country u) {
        em.merge(u);
    }

    public void removeCountry(Integer id) {
        Country u = em.find(Country.class, id);
        em.remove(u);
    }

    public Country getCountryByCountryId(Integer id) {
        return em.find(Country.class, id);
    }

}