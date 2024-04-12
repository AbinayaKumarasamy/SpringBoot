package com.example.projectr1.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Sort;

import com.example.projectr1.model.Login;
import com.example.projectr1.repository.LoginRepo;

@Service
public class LoginService {
    @Autowired
    LoginRepo lr;
    public Login create(Login ll)
    {
        return lr.save(ll);
    } 
    public List<Login> getAll()
    {
        return lr.findAll();
    }
    public Login getMe(int id)
    {
        return lr.findById(id).orElse(null);
    }
    public boolean updateDetails(int id,Login mm)
        {
            if(this.getMe(id)==null)
            {
                return false;
            }
            try{
                lr.save(mm);
            }
            catch(Exception e)
            {
                return false;
            }
            return true;
        }
public boolean deleteuser(int id)
        {
            if(this.getMe(id) == null)
            {
                return false;
            }
            lr.deleteById(id);
            return true;
        }

//pagination and sorting
public List<Login> getsort(int pageNumber,int pageSize,String field)
{          return lr.findAll(PageRequest.of(pageNumber, pageSize)
      .withSort(Sort.by(Sort.Direction.ASC,field))).getContent();
}
public List<Login> sort(String field)
    {
        Sort sort=Sort.by(Sort.Direction.ASC,field);
        return lr.findAll(sort);
    }


 //SELECT QUERY FUNCTION 
 public List <Login> getDetailsbyStatus(){
    return lr.findByStatus();
}


    // //DELETE QUERY FUNCTION 
    // public Integer deletepatientdetails(int patientId){
	// 	return lr.deletepatientInfo(patientId);
	// }

    
}
