package com.example.findtoheal;

public class doctor {
    private String name;
    private String specialty;
    private String hospital;
    private String email;
    private String phone;

    public doctor() {
        // Default constructor required for Firebase
    }

    public String getName() {
        return name;
    }

    public String getSpecialty() {
        return specialty;
    }

    public String getHospital() {
        return hospital;
    }

    public String getEmail() {
        return email;
    }

    public String getPhone() {
        return phone;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSpecialty(String specialty) {
        this.specialty = specialty;
    }

    public void setHospital(String hospital) {
        this.hospital = hospital;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String toString() {
        return "doctor{" +
                "name='" + name + '\'' +
                ", specialty='" + specialty + '\'' +
                ", hospital='" + hospital + '\'' +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                '}';
    }
}