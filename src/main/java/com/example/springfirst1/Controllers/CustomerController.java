package com.example.springfirst1.Controllers;

import com.example.springfirst1.Services.CustomerService;
import com.example.springfirst1.entity.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

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

}
