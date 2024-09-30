
package com.boubyan.task.controller;

import com.boubyan.task.exception.UserCourseDuplicateException;
import com.boubyan.task.model.dao.UserCourseDao;
import com.boubyan.task.service.UserCourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/app/register")
public class RegistrationController {

    @Autowired
    UserCourseService userCourseService;

    @PreAuthorize("hasAnyAuthority({'student','admin'})")
    @GetMapping
    public ResponseEntity<UserCourseDao> findAll(@RequestBody UserCourseDao userCourseDao) throws UserCourseDuplicateException {
        return ResponseEntity.ok(userCourseService.addUserCourse(userCourseDao));
    }

    @PreAuthorize("hasAnyAuthority({'student','admin'})")
    @PostMapping
    public ResponseEntity<UserCourseDao> addUserCourse(@RequestBody UserCourseDao userCourseDao) throws UserCourseDuplicateException {
        return ResponseEntity.ok(userCourseService.addUserCourse(userCourseDao));
    }

    @PreAuthorize("hasAnyAuthority({'student','admin'})")
    @PostMapping("/cancel")
    public ResponseEntity<String> deleteUserCourse(@RequestBody UserCourseDao userCourseDao) {
        userCourseService.deleteUserCourse(userCourseDao);
        return ResponseEntity.ok("Canceled");
    }

}
