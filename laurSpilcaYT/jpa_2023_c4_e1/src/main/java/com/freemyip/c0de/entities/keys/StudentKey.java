package com.freemyip.c0de.entities.keys;

import java.io.Serializable;

public class StudentKey implements Serializable {
    
    private Integer rollNumber;
    private Integer universityId;
    
    public Integer getRollNumber() {
        return rollNumber;
    }
    public void setRollNumber(Integer rollNumber) {
        this.rollNumber = rollNumber;
    }
    public Integer getUniversityId() {
        return universityId;
    }
    public void setUniversityId(Integer univeristyId) {
        this.universityId = univeristyId;
    }

    
    
}
