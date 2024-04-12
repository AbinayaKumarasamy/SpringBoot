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
import com.example.projectr1.model.Login;
import com.example.projectr1.model.Patient;
import com.example.projectr1.service.LoginService;
@RestController
public class LoginController {
    @Autowired
    LoginService ms;
    @PostMapping("/postdetails")
    public ResponseEntity<Login>addelements(@RequestBody Login m)
    {
        Login mm=ms.create(m);
        return new ResponseEntity<>(mm,HttpStatus.CREATED);
    }
    @GetMapping("/getdetails")
    public ResponseEntity<List<Login>> showinfo()
    {
        List<Login>obj=ms.getAll();
        return new ResponseEntity<>(obj,HttpStatus.OK);
    }
    @GetMapping("/getdetailsbyid")
    public ResponseEntity<Login> getById(@PathVariable Integer loginId)
    {
        Login obj=ms.getMe(loginId);
        return new ResponseEntity<>(obj,HttpStatus.OK);
    }
    @PutMapping("/putdetails/{patientId}")
    public ResponseEntity<Login> putMethodName(@PathVariable("patientId") int id, @RequestBody Login m) {
        if(ms.updateDetails(id,m) == true)
        {
            return new ResponseEntity<>(m,HttpStatus.OK);
        }
        
        return new ResponseEntity<>(null,HttpStatus.NOT_FOUND);
    }
    @DeleteMapping("/deletedetails/{patientId}")
    public ResponseEntity<Boolean> delete(@PathVariable("patientId") int id)
    {
        if(ms.deleteuser(id) == true)
        {
            return new ResponseEntity<>(true,HttpStatus.OK);
        }
        return new ResponseEntity<>(false,HttpStatus.NOT_FOUND);
    }

    //pagination and sorting 
    
    @GetMapping("/api/patient/{offset}/{pagesize}/{field}")
    public List<Login> getsorting(@PathVariable int offset,@PathVariable int pagesize,@PathVariable String field)
    {
        return ms.getsort(offset,pagesize,field);
    }
    @GetMapping("/api/patient/sortBy/{field}")
    public List<Login> g(@PathVariable String field)
    {
        return ms.sort(field);
    }
    // SELECT QUERY METHOD

    @GetMapping("/status")
    public List<Login> getDetailsbyStatus() {
        return ms.getDetailsbyStatus();
    }

    // //DELETE QUERY METHOD
    // @DeleteMapping("/delete/query/{email}")
	// public String deletepatientInfo(@PathVariable int patientId){
	// 	return ms.deletepatientInfo(patientId)+" Deleted";
	// }


}