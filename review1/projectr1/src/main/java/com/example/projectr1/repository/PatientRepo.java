package com.example.projectr1.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.projectr1.model.Patient;

public interface PatientRepo extends JpaRepository<Patient,String>{
    
}
