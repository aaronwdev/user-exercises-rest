package com.williams.userexercisesrest.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.sql.Date;

@Entity
@Table(name = "USER_EXERCISE_LOG")
public class UserExerciseLogEntity {

    public UserExerciseLogEntity() {
    }

    public UserExerciseLogEntity(int userId, int exerciseId, Date date) {
        this.userID = userId;
        this.exerciseId = exerciseId;
        this.date = date;
    }

    @Id
    @GeneratedValue
    @Column(name = "ID")
    private int id;

    @Column(name = "USER_ID")
    private int userID;

    @Column(name = "EXERCISE_ID")
    private int exerciseId;

    @Column(name = "DATE")
    private Date date;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public int getExerciseId() {
        return exerciseId;
    }

    public void setExerciseId(int exerciseId) {
        this.exerciseId = exerciseId;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
