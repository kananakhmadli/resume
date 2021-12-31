package com.company.security;

import com.company.entity.User;
import com.company.service.inter.UserServiceInter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.userdetails.User.UserBuilder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Slf4j
@Service("userDetailsService")
public class CustomUserDetailsService implements UserDetailsService {

    private final UserServiceInter userServiceInter;

    public CustomUserDetailsService(UserServiceInter userServiceInter) {
        this.userServiceInter = userServiceInter;
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        User user = userServiceInter.findByEmail(email);
        UserBuilder builder;
        log.info(user.toString());
        builder = org.springframework.security.core.userdetails.User.withUsername(email);
        builder.disabled(false);
        builder.password(user.getPassword());

        String[] authorities = new String[user.getGroupUsers().size()];
        for (int i = 0; i < user.getGroupUsers().size(); i++) {
            authorities[i] = user.getGroupUsers().get(i).getMyGroup().getName();
        }
        log.info(Arrays.toString(authorities));
        log.info("++++++++++++++++++++++++++++++++++++++++++++++++");
        builder.authorities(authorities);
        return builder.build();
    }

}