package com.boubyan.task.model.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@Entity
@Table(name = "COURSE")
@SequenceGenerator(sequenceName = "COURSE_SEQ", name = "baseSequence", allocationSize = 1)
public class Course extends BaseEntity {

    private String name;
    private Date startDate;
    private Date endDate;
}
