package com.boubyan.task.repository;

import com.boubyan.task.model.entity.User;
import com.boubyan.task.model.entity.UserRole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRoleRepository extends JpaRepository<UserRole, Long> {
}
