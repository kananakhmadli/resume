package com.company.repository;

import com.company.entity.Country;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class CountryRepository extends abstractDao {

    private Country getCountry(ResultSet rs) throws Exception {
        int id = rs.getInt("id");
        String name = rs.getString("name");
        String surname = rs.getString("nationality");
        return new Country(id, name, surname);
    }

    public List<Country> getAll() {
        List<Country> list = new ArrayList<>();
        try ( Connection c = connect()) {
            Statement stmt = c.createStatement();
            stmt.execute("select* from country");
            ResultSet rs = stmt.getResultSet();
            while (rs.next()) {
                Country con = getCountry(rs);
                list.add(con);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return list;
    }

    public boolean updatCountry(Country u) {
        try ( Connection c = connect()) {
            PreparedStatement stmt = c.prepareStatement("update country set name=?,nationality=? where id=?");
            stmt.setString(1, u.getName());
            stmt.setString(2, u.getNationality());
            stmt.setInt(3, u.getId());
            return stmt.execute();
        } catch (Exception ex) {
            ex.printStackTrace();
            return false;
        }
    }

    public boolean removeCountry(int id) {
        try ( Connection c = connect()) {
            PreparedStatement ps = c.prepareStatement("delete from country where id=?");
            ps.setInt(1, id);
            return ps.execute();
        } catch (Exception ex) {
            ex.printStackTrace();
            return false;
        }
    }

    public Country getById(int id) {
        Country con = null;
        try ( Connection c = connect()) {
            Statement stmt = c.createStatement();
            stmt.execute("select* from country where id=" + id);
            ResultSet rs = stmt.getResultSet();
            while (rs.next()) {
                con = getCountry(rs);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return con;
    }
}