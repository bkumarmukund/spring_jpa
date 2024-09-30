package com.freemyip.c0de.entities;

import com.freemyip.c0de.entities.keys.StudentKey;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import jakarta.persistence.Table;

@Entity
@Table(name = "student")
@IdClass(StudentKey.class)
public class Student {

    @Id
    private Integer rollNumber;
    @Id
    private Integer universityId;
    private String name;

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public Integer getRollNumber() {
        return rollNumber;
    }
    public void setRollNumber(Integer rollNumber) {
        this.rollNumber = rollNumber;
    }
    public Integer getUniversityId() {
        return universityId;
    }
    public void setUniversityId(Integer universityId) {
        this.universityId = universityId;
    }
    @Override
    public String toString() {
        return "Student [rollNumber=" + rollNumber + ", universityId=" + universityId + ", name=" + name + "]";
    }

}
