package com.boubyan.task.model.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;

@Getter
@Setter
@MappedSuperclass
public abstract class BaseEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "baseSequence")
    @Column(name = "ID")
    private Long id;

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}

