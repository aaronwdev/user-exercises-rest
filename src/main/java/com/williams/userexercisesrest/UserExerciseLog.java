package com.williams.userexercisesrest;

import java.sql.Date;

public class UserExerciseLog {

    private int id;
    private int exerciseId;
    private Date date;

    private int userID;
    private String userName;
    private String description;

    @Override
    public String toString() {
        return "The log ID is " + getId() + " and this exercise ID is " + getExerciseId();
    }

    public int getId() {
        return id;
    }

    public void setId(int logId) {
        this.id = logId;
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

    public int getUserID() {
        return userID;
    }

    public void setUserId(int userId) {
        this.userID = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}

