package com.boubyan.task.mapper;

import com.boubyan.task.model.dao.CourseDao;
import com.boubyan.task.model.dao.UserCourseDao;
import com.boubyan.task.model.dao.UserDao;
import com.boubyan.task.model.entity.Course;
import com.boubyan.task.model.entity.User;
import com.boubyan.task.model.entity.UserCourse;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-09-30T14:31:48+0300",
    comments = "version: 1.5.3.Final, compiler: javac, environment: Java 21.0.1 (Oracle Corporation)"
)
@Component
public class UserCourseMapperImpl implements UserCourseMapper {

    @Override
    public UserCourse toUserCourse(UserCourseDao userCourseDao) {
        if ( userCourseDao == null ) {
            return null;
        }

        UserCourse userCourse = new UserCourse();

        userCourse.setId( userCourseDao.getId() );
        userCourse.setUser( userDaoToUser( userCourseDao.getUser() ) );
        userCourse.setUserId( userCourseDao.getUserId() );
        userCourse.setCourse( courseDaoToCourse( userCourseDao.getCourse() ) );
        userCourse.setCourseId( userCourseDao.getCourseId() );

        return userCourse;
    }

    @Override
    public UserCourseDao toUserCourseDto(UserCourse userCourse) {
        if ( userCourse == null ) {
            return null;
        }

        UserCourseDao userCourseDao = new UserCourseDao();

        userCourseDao.setId( userCourse.getId() );
        userCourseDao.setUserId( userCourse.getUserId() );
        userCourseDao.setCourseId( userCourse.getCourseId() );
        userCourseDao.setUser( userToUserDao( userCourse.getUser() ) );
        userCourseDao.setCourse( courseToCourseDao( userCourse.getCourse() ) );

        return userCourseDao;
    }

    @Override
    public List<UserCourseDao> toUserCourseDtoList(List<UserCourse> userCourse) {
        if ( userCourse == null ) {
            return null;
        }

        List<UserCourseDao> list = new ArrayList<UserCourseDao>( userCourse.size() );
        for ( UserCourse userCourse1 : userCourse ) {
            list.add( toUserCourseDto( userCourse1 ) );
        }

        return list;
    }

    protected User userDaoToUser(UserDao userDao) {
        if ( userDao == null ) {
            return null;
        }

        User user = new User();

        user.setId( userDao.getId() );
        user.setUserName( userDao.getUserName() );
        user.setEmail( userDao.getEmail() );
        user.setPassword( userDao.getPassword() );

        return user;
    }

    protected Course courseDaoToCourse(CourseDao courseDao) {
        if ( courseDao == null ) {
            return null;
        }

        Course course = new Course();

        course.setId( courseDao.getId() );
        course.setName( courseDao.getName() );
        course.setStartDate( courseDao.getStartDate() );
        course.setEndDate( courseDao.getEndDate() );

        return course;
    }

    protected UserDao userToUserDao(User user) {
        if ( user == null ) {
            return null;
        }

        UserDao userDao = new UserDao();

        userDao.setId( user.getId() );
        userDao.setUserName( user.getUserName() );
        userDao.setEmail( user.getEmail() );
        userDao.setPassword( user.getPassword() );

        return userDao;
    }

    protected CourseDao courseToCourseDao(Course course) {
        if ( course == null ) {
            return null;
        }

        CourseDao courseDao = new CourseDao();

        courseDao.setId( course.getId() );
        courseDao.setName( course.getName() );
        courseDao.setStartDate( course.getStartDate() );
        courseDao.setEndDate( course.getEndDate() );

        return courseDao;
    }
}
