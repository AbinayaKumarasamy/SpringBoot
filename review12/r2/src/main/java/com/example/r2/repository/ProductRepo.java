package com.example.r2.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.r2.model.Product;

public interface ProductRepo extends JpaRepository<Product,String>{
    
}
