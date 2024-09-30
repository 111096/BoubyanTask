package com.boubyan.task.service;

import com.boubyan.task.exception.UserCourseDuplicateException;
import com.boubyan.task.mapper.UserCourseMapper;
import com.boubyan.task.model.dao.UserCourseDao;
import com.boubyan.task.model.entity.UserCourse;
import com.boubyan.task.repository.UserCourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class UserCourseService {

    private final UserCourseRepository userCourseRepository;
    private final UserCourseMapper userCourseMapper;

    @Autowired
    public UserCourseService(UserCourseRepository userCourseRepository, UserCourseMapper userCourseMapper) {
        this.userCourseRepository = userCourseRepository;
        this.userCourseMapper = userCourseMapper;
    }

    public UserCourseDao addUserCourse(UserCourseDao userCourse) throws UserCourseDuplicateException {
        UserCourse course = userCourseMapper.toUserCourse(userCourse);
        if (userCourseRepository.existsByUserIdAndCourseId(userCourse.getUserId(), userCourse.getCourseId()))
            throw new UserCourseDuplicateException("Duplicate User Course");
        return userCourseMapper.toUserCourseDto(userCourseRepository.save(course));
    }

    public void deleteUserCourse(UserCourseDao userCourse) {
        userCourseRepository.deleteByUserIdAndAndCourseId(userCourse.getUserId(), userCourse.getCourseId());
    }

}
