package com.boubyan.task.model.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "ROLES")
@SequenceGenerator(sequenceName = "GROUP_SEQ", name = "baseSequence", allocationSize = 1)
public class Role extends BaseEntity {

    private String name;
}
