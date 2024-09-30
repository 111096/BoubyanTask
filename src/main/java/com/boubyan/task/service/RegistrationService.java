package com.boubyan.task.service;

import com.boubyan.task.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class RegistrationService {

    private RoleRepository roleRepository;

    @Autowired
    public RegistrationService(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

}
