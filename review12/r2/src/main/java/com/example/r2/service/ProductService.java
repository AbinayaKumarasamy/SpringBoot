package com.example.r2.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.r2.model.Product;
import com.example.r2.repository.ProductRepo;



@Service
public class ProductService {
    @Autowired
    ProductRepo pr;

    public Product create(Product p) {
        return pr.save(p);
    }

    public List<Product> getalldetail() {
        return pr.findAll();
    }
    public Product getUserByName(String username)
    {
        return pr.findById(username).orElse(null);
    }
    public boolean updateDetails(String username,Product p)
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