package com.freemyip.c0de.entities;

import com.freemyip.c0de.entities.keys.EmployeeKey;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "employee")
public class Employee {

    @EmbeddedId
    private EmployeeKey id;
    
    private String name;

    private String address;

    public EmployeeKey getId() {
        return id;
    }

    public void setId(EmployeeKey id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "Employee [id=" + id + ", name=" + name + ", address=" + address + "]";
    }
    
    
}
