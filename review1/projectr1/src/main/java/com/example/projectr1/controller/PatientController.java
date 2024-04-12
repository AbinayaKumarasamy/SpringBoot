package com.example.projectr1.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.projectr1.model.Patient;
import com.example.projectr1.service.PatientService;

@RestController
public class PatientController {
    @Autowired
    PatientService ps;
    @PostMapping("/api/patient")
    public ResponseEntity<Patient> add(@RequestBody Patient p) {
        Patient pro = ps.create(p);
        return new ResponseEntity<>(pro, HttpStatus.CREATED);
    }

    @GetMapping("/api/patient")
    public ResponseEntity<List<Patient>> showdetails() {
        return new ResponseEntity<>(ps.getalldetail(), HttpStatus.OK);
    }
    @PutMapping("/putdata/{username}")
        public ResponseEntity<Patient>putMethodName(@PathVariable("username")String username,@RequestBody Patient p)
        {
            if(ps.updateDetails(username,p) == true)
            {
                return new ResponseEntity<>(p,HttpStatus.OK);
            }
            return new ResponseEntity<>(null,HttpStatus.NOT_FOUND);
        }
        @DeleteMapping("/delete/{username}")
        public ResponseEntity<Boolean>delete(@PathVariable("username")String username)
        {
            if(ps.delete(username) == true)
            {
                return new ResponseEntity<>(true,HttpStatus.OK);
            }
            return new ResponseEntity<>(false,HttpStatus.NOT_FOUND);
        }
    
}
