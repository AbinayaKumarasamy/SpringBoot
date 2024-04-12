package com.example.projectr1.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.projectr1.model.Login;
// import com.example.projectr1.model.Patient;

import jakarta.transaction.Transactional;

public interface LoginRepo extends JpaRepository<Login,Integer>{
    @Query("SELECT f FROM Login f WHERE f.status='no'")
    List<Login> findByStatus();

    // //DELETE QUERY
    // @Modifying
	// @Transactional
	// @Query(value="delete from login where patientId=:s",nativeQuery=true)
	// public Integer deletepatientInfo(@Param("s") int patientId);


    
}
