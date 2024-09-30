package com.boubyan.task.service;

import com.boubyan.task.model.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Set;
import java.util.stream.Collectors;

@Service
@Transactional
public class CustomUserDetailsService implements UserDetailsService {

    UserService userService;
    AuthService authService;

    @Autowired
    CustomUserDetailsService(UserService userService
            , AuthService authService) {
        this.userService = userService;
        this.authService = authService;
    }

    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        User user = userService.findByUserNameOrEmail(userName, userName)
                .orElseThrow(() -> new UsernameNotFoundException("UserDao Not Found with email or userName => " + userName));

        Set<GrantedAuthority> authoritySet = authService.getUserRoleByUser(user)
                .stream().map((role) -> new SimpleGrantedAuthority(role.getName())).collect(Collectors.toSet());

        return new org.springframework.security.core.userdetails.User(user.getUserName(), user.getPassword(), authoritySet);
    }
}
