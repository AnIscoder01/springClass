package com.example.springfirst1.RestControllers;

import com.example.springfirst1.Services.CustomerService;
import com.example.springfirst1.entity.Customer;
import com.example.springfirst1.entity.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/customer")
public class CustomerRestController {
    @Autowired
    CustomerService customerService;

    @PostMapping("/save")
    public Customer createCustomer(@RequestBody Customer customer){

        return customerService.createCustomer(customer);

    }


    @GetMapping("/all")
    public List<Customer> getAllProducts() {
        return customerService.getAllCustomers();
    }

    @GetMapping("/getOne/{id}")
    public Customer getCustomer(@PathVariable int id) {
        return customerService.getCustomerById(id);
    }

    @PutMapping("/update/{id}")
    public Customer updateCustomer(@PathVariable int id, @RequestBody Customer customer){
        Customer C1 = customerService.getCustomerById(id);

        if (C1!=null){
            customer.setId(id);
            return  customerService.updateCustomer(customer);
        }
        else {
            throw new RuntimeException(";Customer not found");

        }
    }

    @DeleteMapping("/delete/{id}")
    public void deleteCustomer(@PathVariable int id){
        customerService.deleteCustomerById(id);
    }


}
