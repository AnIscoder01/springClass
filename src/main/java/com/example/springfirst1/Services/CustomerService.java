package com.example.springfirst1.Services;

import com.example.springfirst1.Repository.CustomerRpository;
import com.example.springfirst1.entity.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService {
    @Autowired
    CustomerRpository customerRpository;

    public Customer createCustomer(Customer customer) {
        return customerRpository.save(customer);
    }

    public List<Customer> getAllCustomers() {
        return customerRpository.findAll();
    }
    public Customer getCustomerById(int id) {
        return customerRpository.findById(id).get();
    }
    public Customer updateCustomer(Customer customer) {
        return customerRpository.save(customer);
    }
    public void deleteCustomerById(int id) {
        customerRpository.deleteById(id);
    }
}
