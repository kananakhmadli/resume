package com.company.service;

import com.company.dao.impl.UserDaoImpl;
import com.company.entity.User;
import com.company.service.inter.UserServiceInter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User.UserBuilder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service("userDetailsService")
public class CustomUserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UserServiceInter userServiceInter;

    UserDaoImpl userDao;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        User user = userServiceInter.findByEmail(email);
        UserBuilder builder = null;
        System.out.println(user);
        if (user != null) {
            builder = org.springframework.security.core.userdetails.User.withUsername(email);
            builder.disabled(false);
            builder.password(user.getPassword());

            String[] authorities = new String[user.getGroupUsers().size()];
            for (int i = 0; i < user.getGroupUsers().size() ; i++) {
                authorities[i]=user.getGroupUsers().get(i).getMyGroup().getName();
            }
            System.out.println(Arrays.toString(authorities));
            System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++");

            builder.authorities(authorities);
            return builder.build();
        } else {
            throw new UsernameNotFoundException("User not found");
        }

    }
}
