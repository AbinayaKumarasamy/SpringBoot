package com.example.projectr1.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
@Entity
public class Patient {
    @Id
    private String username;
    private String password;
    public Patient() {

    }
    public Patient(String username, String password) {
        this.username = username;
        this.password = password;
    }
    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }
    public String getPassword()
    {
        return password;
    }
    public void setPassword(String password)
    {
        this.password = password;
    }


     //ONE TO ONE CONNECTION
     @OneToOne(mappedBy = "patient", cascade = CascadeType.ALL)
     @JsonManagedReference 
     private Login login;
    
}
