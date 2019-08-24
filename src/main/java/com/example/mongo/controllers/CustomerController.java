package com.example.mongo.controllers;

import com.example.mongo.service.CustomerService;
import com.example.mongo.entities.Customer;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/customers")
public class CustomerController {

    @Autowired
    private CustomerService customerService;


    @GetMapping()
    public ResponseEntity<?> getCustomers() {
        List<Customer> customers = customerService.retrieveCustomers();
        return ResponseEntity.ok(customers);
    }


    @PostMapping()
    public ResponseEntity<?> postCustomers(@RequestBody Customer body) {
        Customer customer = customerService.createCustomer(body);
        return ResponseEntity.status(HttpStatus.CREATED).body(customer);
    }
}