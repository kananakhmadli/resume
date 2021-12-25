package com.company.dao.inter;

import com.company.entity.Country;

import java.util.List;

public interface CountryDaoInter {

    List<Country> getAll();

    Country getById(int id);

    boolean updatCountry(Country c);

    boolean removeCountry(int id);

}