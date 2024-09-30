package com.boubyan.task.repository;

import com.boubyan.task.model.entity.Course;
import com.boubyan.task.model.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CourseRepository extends JpaRepository<Course, Long> {

}
