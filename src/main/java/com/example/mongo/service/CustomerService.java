package com.example.mongo.service;

import com.example.mongo.repository.CustomerRepository;
import com.example.mongo.entities.Customer;


import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerService {

    private CustomerRepository repository;

    @Autowired
    public CustomerService(CustomerRepository repository) {
        this.repository = repository;        
    }

    public List<Customer> retrieveCustomers() {
        return repository.findAll();
    }

    public Customer createCustomer(Customer customer) {
        System.out.println(customer.toString());
        return repository.save(customer);
    }
}