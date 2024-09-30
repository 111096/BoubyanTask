package com.boubyan.task.controller;

import com.boubyan.task.model.dao.LoginReqDao;
import com.boubyan.task.model.dao.LoginResDao;
import com.boubyan.task.service.AuthService;
import com.boubyan.task.service.LoginService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    LoginService loginService;
    AuthService authService;

    AuthController(AuthService authService, LoginService loginService) {
        this.authService = authService;
        this.loginService = loginService;
    }

    @PostMapping(value = {"/login", "/signin"})
    public ResponseEntity<LoginResDao> login(@RequestBody LoginReqDao loginDto) {
        return ResponseEntity.ok(loginService.login(loginDto));
    }
}
