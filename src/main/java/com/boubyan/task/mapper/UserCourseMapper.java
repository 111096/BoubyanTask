package com.boubyan.task.mapper;

import com.boubyan.task.model.dao.UserCourseDao;
import com.boubyan.task.model.entity.UserCourse;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface UserCourseMapper {

    UserCourse toUserCourse(UserCourseDao userCourseDao);

    UserCourseDao toUserCourseDto(UserCourse userCourse);

    List<UserCourseDao> toUserCourseDtoList(List<UserCourse> userCourse);

}
