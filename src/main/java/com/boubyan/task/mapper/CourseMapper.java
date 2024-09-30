package com.boubyan.task.mapper;

import com.boubyan.task.model.dao.CourseDao;
import com.boubyan.task.model.entity.Course;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CourseMapper {

    Course toCourse(CourseDao courseDao);

    CourseDao toCourseDto(Course course);

    List<CourseDao> toCourseDtos(List<Course> course);

}
