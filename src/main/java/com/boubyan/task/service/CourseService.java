package com.boubyan.task.service;

import com.boubyan.task.exception.CourseNotFoundException;
import com.boubyan.task.mapper.CourseMapper;
import com.boubyan.task.model.dao.CourseDao;
import com.boubyan.task.model.entity.Course;
import com.boubyan.task.repository.CourseRepository;
import com.boubyan.task.utils.HelperClass;
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
@Transactional
public class CourseService {

    private CourseRepository courseRepository;
    private CourseMapper courseMapper;

    @Autowired
    public CourseService(CourseRepository courseRepository, CourseMapper courseMapper) {
        this.courseRepository = courseRepository;
        this.courseMapper = courseMapper;
    }

    @Cacheable(value = "course", key = "#courses")
    public List<CourseDao> findAllCourse() {
        return courseMapper.toCourseDtos(courseRepository.findAll());
    }

    public CourseDao findCourseById(Long id) throws CourseNotFoundException {
        Optional<Course> course = courseRepository.findById(id);
        if (course.isPresent())
            return courseMapper.toCourseDto(course.get());
        throw new CourseNotFoundException("Course Not Found With Id: " + id);
    }

    public byte[] printCourse() {
        List<CourseDao> courseDaoList = findAllCourse();
        byte[] data = new byte[0];
        try {
            JRBeanCollectionDataSource beanCollectionDataSource = new JRBeanCollectionDataSource(courseDaoList, false);

            Map<String, Object> parameters = fillCourseReportParam();
            JasperReport compileReport = JasperCompileManager.compileReport(HelperClass.locateFile("jasper-report/course/course.jrxml"));
            JasperPrint jasperPrint = JasperFillManager.fillReport(compileReport, parameters, beanCollectionDataSource);
            data = JasperExportManager.exportReportToPdf(jasperPrint);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return data;
    }

    private Map<String, Object> fillCourseReportParam() {
        Map<String, Object> parameters = new HashMap<>();
        parameters.put("Title", "Boubyan Bank");
        return parameters;
    }
}
