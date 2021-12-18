package com.company.dao.inter;

import com.company.entity.GroupUser;
import com.company.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface GroupUserRepository extends JpaRepository<GroupUser, Integer> {

//    @Query(value = "select * from User u where u.email=?1 ", nativeQuery = true)
//    @Query(value = "select * from User u where u.email=? ", nativeQuery = true)
     GroupUser findGroupUserById(Integer id);

//
//    @Query("select u from User u where u.email=:em")
//    User findByEmail(@Param("em") String em);


}
