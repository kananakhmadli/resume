package com.company.dao.inter;

import com.company.entity.Country;

import java.util.List;

public interface CountryDaoInter {

    List<Country> getAll();

    Country getById(int id);

    boolean updateCountry(Country c);

    boolean removeCountry(int id);

}