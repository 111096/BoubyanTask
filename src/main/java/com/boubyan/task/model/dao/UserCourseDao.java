package com.boubyan.task.model.dao;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class UserCourseDao extends BaseDao {

    private Long userId;
    private Long courseId;
    private UserDao user;
    private CourseDao course;
}
