package com.example.projectr1.model;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;

@Entity
public class Login {
    @Id
    int patientId;
    String name,address,dob,status;
    int phonenumber;
    public int getPatientId() {
        return patientId;
    }
    public void setPatientId(int patientId) {
        this.patientId = patientId;
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
    public String getDob() {
        return dob;
    }
    public void setDob(String dob) {
        this.dob = dob;
    }
    public String getStatus() {
        return status;
    }
    public void setStatus(String status) {
        this.status = status;
    }
    public int getPhonenumber() {
        return phonenumber;
    }
    public void setPhonenumber(int phonenumber) {
        this.phonenumber = phonenumber;
    }
    public Login(int patientId, String name, String address, String dob, String status, int phonenumber) {
        this.patientId = patientId;
        this.name = name;
        this.address = address;
        this.dob = dob;
        this.status = status;
        this.phonenumber = phonenumber;
    }
    public Login() {
    }
    @OneToOne
    @JsonBackReference
    private Patient patient;
    
    
}
