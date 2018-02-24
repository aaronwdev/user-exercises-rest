package com.williams.userexercisesrest.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "EXERCISE")
public class ExerciseEntity {

    public ExerciseEntity() {}

    public ExerciseEntity(String description) {
        this.description = description;
    }

    @Id
    @GeneratedValue
    @Column(name = "ID")
    private int id;

    @Column(name = "DESCRIPTION")
    private String description;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
