package com.company.repository;

import com.company.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface UserRepository extends JpaRepository<User, Integer> {

    User findByName(String nm);

    User findByNameAndSurname(String nm, String sr);

    User findByPhone(String num);

//    @Query(value = "select * from User u where u.email=?1 ", nativeQuery = true)
//    @Query(value = "select * from User u where u.email=? ", nativeQuery = true)
//    User findByEmail(String em);

    @Query("select u from User u where u.email=:em")
    User findByEmail(@Param("em") String em);

}