
package com.boubyan.task.controller;

import com.boubyan.task.exception.CourseNotFoundException;
import com.boubyan.task.model.dao.CourseDao;
import com.boubyan.task.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/app/course")
public class CourseController {

    @Autowired
    CourseService courseService;

    @PreAuthorize("hasAnyAuthority({'student','admin'})")
    @GetMapping
    public ResponseEntity<List<CourseDao>> findAllCourse() {
        return ResponseEntity.ok(courseService.findAllCourse());
    }

    @PreAuthorize("hasAnyAuthority({'student','admin'})")
    @GetMapping("/{id}")
    public ResponseEntity<CourseDao> findCourseById(@PathVariable Long id) throws CourseNotFoundException {
        return ResponseEntity.ok(courseService.findCourseById(id));
    }

    @GetMapping(value = "/report", produces = MediaType.APPLICATION_PDF_VALUE)
    public ResponseEntity<?> printCourse(@RequestParam(required = false) Map<String, Object> params) {
        return ResponseEntity.ok(courseService.printCourse());

    }
}
