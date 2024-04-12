package com.example.projectr1.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.projectr1.model.Patient;
import com.example.projectr1.repository.PatientRepo;

@Service
public class PatientService {
    @Autowired
    PatientRepo pr;

    public Patient create(Patient p) {
        return pr.save(p);
    }

    public List<Patient> getalldetail() {
        return pr.findAll();
    }
    public Patient getUserByName(String username)
    {
        return pr.findById(username).orElse(null);
    }
    public boolean updateDetails(String username,Patient p)
    {
        if(this.getUserByName(username)==null)
        {
            return false;
        }
        try{
            pr.save(p);
        }
        catch(Exception e)
        {
            return false;
        }
        return true;
    }
    public boolean delete(String username)
    {
        if(this.getUserByName(username) == null)
        {
            return false;
        }
        pr.deleteById(username);
        return true;
    }
    
}
