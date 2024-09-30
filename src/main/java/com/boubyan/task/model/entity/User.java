package com.boubyan.task.model.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "USERS")
@SequenceGenerator(sequenceName = "USER_SEQ", name = "baseSequence", allocationSize = 1)
public class User extends BaseEntity {

    @Column(name = "USER_NAME", nullable = false)
    private String userName;
    private String email;
    private String password;

}
