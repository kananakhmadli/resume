package com.company.dao.impl;

import com.company.dao.inter.AbstractDAO;
import com.company.dao.inter.UserDaoInter;
import com.company.entity.Country;
import com.company.entity.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserDaoImpl extends AbstractDAO implements UserDaoInter {


    private User getUserSimp(ResultSet rs) throws Exception {
        int id = rs.getInt("id");
        String name = rs.getString("name");
        String surname = rs.getString("surname");
        String phone = rs.getString("phone");
        String email = rs.getString("email");
        String profileDesc = rs.getString("profile_desc");
        String address = rs.getString("address");
        Date birth_date = rs.getDate("birth_date");

        return new User(id, name, surname, phone, email, profileDesc, address, birth_date, null);

    }

    private User getUser(ResultSet rs) throws Exception {

        int nationalityId = rs.getInt("nationality_id");
        String nationlitStr = rs.getString("nationality");
        String city = rs.getString("city");
        Country nationality = new Country(nationalityId, city, nationlitStr);

        User u = getUserSimp(rs);
        u.setNationality(nationality);
        return u;
    }

    @Override
    public List<User> getAll(String name, String surname, Integer nationalityId) {
        List<User> list = new ArrayList<>();
        try (Connection c = connect()) {
            String sql = "SELECT u.*, c.nationality,c.name city FROM USER u LEFT JOIN country c ON u.nationality_id = c.id WHERE 1=1";

            if (name != null && !name.trim().isEmpty()) {
                sql += " and u.name=?";

            }
            if (surname != null && !surname.trim().isEmpty()) {
                sql += " and u.surname=?";

            }
            if (nationalityId != null) {
                sql += " and u.nationality_id=?";

            }
            PreparedStatement stmt = c.prepareStatement(sql);
            int i = 1;
            if (name != null && !name.trim().isEmpty()) {
                stmt.setString(i, name);
                i++;
            }
            if (surname != null && !surname.trim().isEmpty()) {
                stmt.setString(i, surname);
                i++;
            }
            if (nationalityId != null) {
                stmt.setInt(i, nationalityId);

            }
            stmt.execute();
            ResultSet rs = stmt.getResultSet();
            while (rs.next()) {
                User u = getUser(rs);
                list.add(u);

            }

        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return list;
    }

    @Override
    public boolean updateUser(User u) {

        try (Connection c = connect()) {
            PreparedStatement stmt = c.prepareStatement("update user set name=?,surname=?,phone=?,email=?,profile_description=?,address=?,birthdate=? where id=?");
            stmt.setString(1, u.getName());
            stmt.setString(2, u.getSurname());
            stmt.setString(3, u.getPhone());
            stmt.setString(4, u.getEmail());
            stmt.setString(5, u.getProfileDesc());
            stmt.setString(6, u.getAddress());
            stmt.setDate(7, u.getBirthDate());
            stmt.setInt(8, u.getId());
            return stmt.execute();
        } catch (Exception ex) {
            ex.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean removeUser(int id) {
        try (Connection c = connect()) {
            Statement stmt = c.createStatement();
            return stmt.execute("delete from user where id=" + id);
        } catch (Exception ex) {
            ex.printStackTrace();
            return false;
        }
    }

    @Override
    public User getById(int userId) {
        User con = null;
        try (Connection c = connect()) {
            Statement stmt = c.createStatement();
            String sql = "SELECT u.*, c.nationality,c.name city FROM USER u LEFT JOIN country c ON u.nationality_id = c.id where u.id=";
            stmt.execute(sql + userId);
            ResultSet rs = stmt.getResultSet();
            while (rs.next()) {

                con = getUser(rs);

            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return con;
    }

    @Override
    public boolean addUser(User u) {
        try (Connection c = connect()) {
            PreparedStatement stmt = c.prepareStatement("INSERT INTO user(name,surname,phone,email,profile_desc) values(?,?,?,?,?)");
            stmt.setString(1, u.getName());
            stmt.setString(2, u.getSurname());
            stmt.setString(3, u.getPhone());
            stmt.setString(4, u.getEmail());
            stmt.setString(5, u.getProfileDesc());
            return stmt.execute();
        } catch (Exception ex) {
            ex.printStackTrace();
            return false;
        }
    }

    @Override
    public User findByEmailAndPassword(String email, String password) {
        User result = null;
        try (Connection c = connect()) {
            PreparedStatement stmt = c.prepareStatement("select* from user where email=? and password=?");
            stmt.setString(1, email);
            stmt.setString(2, password);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                result = getUserSimp(rs);

            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

}
