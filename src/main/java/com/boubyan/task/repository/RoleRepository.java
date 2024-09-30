package com.boubyan.task.repository;

import com.boubyan.task.model.entity.Role;
import com.boubyan.task.model.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {

    Optional<Role> findByName(String name);

    @Query("Select ur.role from UserRole ur where ur.user = :user")
    List<Role> findRolesByUser(User user);
}
