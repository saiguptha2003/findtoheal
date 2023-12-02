package com.example.findtoheal;

public class disease {
    String name;
    String group;
    doctor doctor;
    public disease() {
        // Default constructor required for Firebase
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setGroup(String group) {
        this.group = group;
    }

    public void setDoctor(com.example.findtoheal.doctor doctor) {
        this.doctor = doctor;
    }

    public String getName() {
        return name;
    }

    public String getGroup() {
        return group;
    }

    public com.example.findtoheal.doctor getDoctor() {
        return doctor;
    }
}