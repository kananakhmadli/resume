package com.company.dao.inter;

import com.company.entity.Country;
import java.util.List;

public interface CountryDaoInter {

    public List<Country> getAll();
    public Country getById(int id);
    public boolean updatCountry(Country c);
    public boolean removeCountry(int id);

}
