package com.boubyan.task.service;

import com.boubyan.task.jwt.JwtTokenProvider;
import com.boubyan.task.mapper.UserMapper;
import com.boubyan.task.model.dao.LoginReqDao;
import com.boubyan.task.model.dao.LoginResDao;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

@Service
public class LoginService {

    AuthenticationManager authenticationManager;
    JwtTokenProvider jwtTokenProvider;
    UserService userService;
    AuthService authService;
    UserMapper userMapper;

    public LoginService(AuthenticationManager authenticationManager, JwtTokenProvider jwtTokenProvider, UserService userService, AuthService authService, UserMapper userMapper) {
        this.authenticationManager = authenticationManager;
        this.jwtTokenProvider = jwtTokenProvider;
        this.userService = userService;
        this.authService = authService;
        this.userMapper = userMapper;
    }

    public LoginResDao login(LoginReqDao loginReqDao) {
        LoginResDao loginResDao = new LoginResDao();
        Authentication authentication = authenticationManager
                .authenticate(new UsernamePasswordAuthenticationToken(loginReqDao.getName(), loginReqDao.getPassword()));

        SecurityContextHolder.getContext().setAuthentication(authentication);
        String token = jwtTokenProvider.generateToken(authentication);
        loginResDao.setToken("Bearer " + token);
        loginResDao.setUser(userMapper.toUserDto(userService.findByUserNameOrEmail(loginReqDao.getName(), loginReqDao.getName()).get()));
        loginResDao.setRole(authService.getUserRoleByUserForLogin(userMapper.toUser(loginResDao.getUser())).stream().toList());
        return loginResDao;
    }
}
