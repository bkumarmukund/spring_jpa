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
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((rollNumber == null) ? 0 : rollNumber.hashCode());
        result = prime * result + ((universityId == null) ? 0 : universityId.hashCode());
        return result;
    }
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        StudentKey other = (StudentKey) obj;
        if (rollNumber == null) {
            if (other.rollNumber != null)
                return false;
        } else if (!rollNumber.equals(other.rollNumber))
            return false;
        if (universityId == null) {
            if (other.universityId != null)
                return false;
        } else if (!universityId.equals(other.universityId))
            return false;
        return true;
    }

    
    
}
