package com.boubyan.task.mapper;

import com.boubyan.task.model.dao.CourseDao;
import com.boubyan.task.model.entity.Course;
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
public class CourseMapperImpl implements CourseMapper {

    @Override
    public Course toCourse(CourseDao courseDao) {
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

    @Override
    public CourseDao toCourseDto(Course course) {
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

    @Override
    public List<CourseDao> toCourseDtos(List<Course> course) {
        if ( course == null ) {
            return null;
        }

        List<CourseDao> list = new ArrayList<CourseDao>( course.size() );
        for ( Course course1 : course ) {
            list.add( toCourseDto( course1 ) );
        }

        return list;
    }
}
