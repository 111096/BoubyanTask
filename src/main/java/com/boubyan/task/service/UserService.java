package com.boubyan.task.service;

import com.boubyan.task.model.entity.User;
import com.boubyan.task.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@Transactional
public class UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public Optional<User> findByUserNameOrEmail(String userName, String email) {
        return userRepository.findByUserNameOrEmail(userName, email);
    }
}
