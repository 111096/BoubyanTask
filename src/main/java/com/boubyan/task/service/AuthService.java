package com.boubyan.task.service;

import com.boubyan.task.model.entity.Role;
import com.boubyan.task.model.entity.User;
import com.boubyan.task.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class AuthService {

    private final RoleRepository roleRepository;

    @Autowired
    public AuthService(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    public List<Role> getUserRoleByUser(User user) {
        return roleRepository.findRolesByUser(user);
    }

    public List<String> getUserRoleByUserForLogin(User user) {
        return roleRepository.findRolesByUser(user).stream().map(Role::getName).toList();
    }
}
