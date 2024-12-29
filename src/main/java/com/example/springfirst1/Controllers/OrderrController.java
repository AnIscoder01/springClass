package com.example.springfirst1.Controllers;

import com.example.springfirst1.Services.CustomerService;
import com.example.springfirst1.Services.OrderrService;
import com.example.springfirst1.entity.Customer;
import com.example.springfirst1.entity.Orderr;
import com.example.springfirst1.entity.Product;
import com.example.springfirst1.entity.Provider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class OrderrController {
    @Autowired
    OrderrService orderrService;

    @Autowired
    CustomerService customerService;

    @RequestMapping("/addOrderr")
    public String addOrderr(Model model) {

        Orderr orderr = new Orderr();

        List<Customer> customers = customerService.getAllCustomers();

        model.addAttribute("OrderrForm",orderr);
        model.addAttribute("listCustomer",customers);
        return "new_orderr";
    }
    @RequestMapping(value="/saveOrderr",method = RequestMethod.POST)
    public String saveOrderr(@ModelAttribute("OrderrForm") Orderr orderr) {
        orderrService.createOrderr(orderr);
        return "redirect:/allOrderrs";
    }

    @RequestMapping("/allOrderrs")
    public String listOrderrs(Model model) {
        List<Orderr> listOrderrs = orderrService.getAllOrderr();
        model.addAttribute("listOrderrs", listOrderrs);
        return "liste_orderrs";
    }
/*
    @GetMapping("/deleteProvider/{id}")
    public String deleteProvider(@PathVariable int id) {
        providerService.deleteProviderById(id);
        return "redirect:/allProviders";
    }

    @GetMapping("editProvider/{id}")
    public String editProvider(@PathVariable int id, Model model) {
        Provider provider = providerService.getProviderById(id);
        model.addAttribute("provider", provider);
        return "update_provider";
    }
    @PostMapping("/updateProvider/{id}")
    public String updateProvider(@PathVariable int id, Provider provider) {
        providerService.updateProvider(provider);
        return "redirect:/allProviders";
    }
*/
}
