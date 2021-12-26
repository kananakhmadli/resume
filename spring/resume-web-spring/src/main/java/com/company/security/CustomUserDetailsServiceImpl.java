package com.company.security;

import com.company.repository.UserRepository;
import com.company.entity.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.userdetails.User.UserBuilder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service("userDetailsService")
@Slf4j
public class CustomUserDetailsServiceImpl implements UserDetailsService {

    private final UserRepository userRepository;

    public CustomUserDetailsServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        User user = userRepository.findByEmail(email);
        UserBuilder builder = null;
        log.info(String.valueOf(user));
        if (user != null) {
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
        } else {
            throw new UsernameNotFoundException("User not found");
        }
    }
}