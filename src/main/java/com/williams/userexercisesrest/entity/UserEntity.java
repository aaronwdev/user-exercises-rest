package com.williams.userexercisesrest.entity;

import org.hibernate.validator.constraints.Length;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "USER")
public class UserEntity {

    public UserEntity() {
    }

    public UserEntity(String name, String postcode) {
        this.name = name;
        this.postcode = postcode;
    }

    @Id
    @GeneratedValue
    @Column(name = "ID")
    private int id;

    @Column(name = "NAME")
    @Length(min=1, max=35)
    private String name;

    @Column(name = "POSTCODE")
    @Length(min=6, max=8)
    private String postcode;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPostcode() {
        return postcode;
    }

    public void setPostcode(String postcode) {
        this.postcode = postcode;
    }
}