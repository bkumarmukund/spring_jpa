package com.freemyip.c0de.entities.keys;

import jakarta.persistence.Embeddable;

@Embeddable
public class EmployeeKey {
    private Integer id;
    private Integer serialNumber;
    
    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public Integer getSerialNumber() {
        return serialNumber;
    }
    public void setSerialNumber(Integer serialNumber) {
        this.serialNumber = serialNumber;
    }

    
}
