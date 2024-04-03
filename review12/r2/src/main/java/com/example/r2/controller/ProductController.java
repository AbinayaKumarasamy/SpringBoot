package com.example.r2.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import com.example.r2.model.Product;
import com.example.r2.service.ProductService;

import java.util.List;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
// import org.springframework.web.bind.annotation.PathVariable;
// import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;


@RestController
public class ProductController {
    @Autowired
    ProductService ps;

    @PostMapping("/api/product")
    public ResponseEntity<Product> add(@RequestBody Product p) {
        Product pro = ps.create(p);
        return new ResponseEntity<>(pro, HttpStatus.CREATED);
    }

    @GetMapping("/api/products")
    public ResponseEntity<List<Product>> showdetails() {
        return new ResponseEntity<>(ps.getalldetail(), HttpStatus.OK);
    }
    @PutMapping("/putdata/{username}")
        public ResponseEntity<Product>putMethodName(@PathVariable("username")String username,@RequestBody Product p)
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