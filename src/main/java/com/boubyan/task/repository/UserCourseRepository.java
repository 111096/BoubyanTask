package com.boubyan.task.repository;

import com.boubyan.task.model.entity.UserCourse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserCourseRepository extends JpaRepository<UserCourse, Long> {
    public boolean existsByUserIdAndCourseId(Long userId, Long courseId);

    public void deleteByUserIdAndAndCourseId(Long userId, Long courseId);
}
