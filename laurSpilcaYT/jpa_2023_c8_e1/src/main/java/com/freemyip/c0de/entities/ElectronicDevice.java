package com.freemyip.c0de.entities;

import jakarta.persistence.Entity;

@Entity
public class ElectronicDevice extends Product{
    
    private String powerSource;

    private boolean backup;

    public String getPowerSource() {
        return powerSource;
    }

    public void setPowerSource(String powerSource) {
        this.powerSource = powerSource;
    }

    public boolean isBackup() {
        return backup;
    }

    public void setBackup(boolean backup) {
        this.backup = backup;
    }

    
}
