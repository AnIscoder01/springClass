package com.example.springfirst1.Controllers;

import com.example.springfirst1.Services.CustomerService;
import com.example.springfirst1.entity.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class CustomerController {
    @Autowired
    CustomerService customerService;

    @RequestMapping("/addCustomer")
    public String addCustomer(Model model) {
        Customer customer = new Customer();
        model.addAttribute("CustomerForm", customer);
        return "new_customer";
    }
    @RequestMapping(value="/saveCustomer",method= RequestMethod.POST)
    public String saveCustomer(@ModelAttribute("CustomerForm") Customer customer) {
        customerService.createCustomer(customer);
        return "redirect:/allCustomers";
    }

    @RequestMapping("/allCustomers")
    public String listCustomer(Model model) {
        List<Customer> listCustomers = customerService.getAllCustomers();
        model.addAttribute("listCustomers", listCustomers);
        return "liste_customers";
    }

    @GetMapping("/deleteCustomer/{id}")
    public String deleteCustomer(@PathVariable int id) {
        customerService.deleteCustomerById(id);
        return "redirect:/allCustomers";
    }

    @GetMapping("editCustomer/{id}")
    public String editCustomer(@PathVariable int id, Model model) {
        Customer customer = customerService.getCustomerById(id);
        model.addAttribute("Customer", customer);
        return "redirect:/allCustomers";
    }

    @PostMapping("/updateCustomer/{id}")
    public String updateCustomer(@PathVariable int id, Customer customer) {
        customerService.updateCustomer(customer);
        return "redirect:/allCustomers";
    }



}
