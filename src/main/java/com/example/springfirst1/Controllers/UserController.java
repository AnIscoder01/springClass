package com.example.springfirst1.Controllers;

import com.example.springfirst1.Services.CustomerService;
import com.example.springfirst1.Services.UserService;
import com.example.springfirst1.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class UserController {
    @Autowired
    UserService userService;


    @RequestMapping("/addUser")
    public String addUser(Model model) {
        User user=new User();
        model.addAttribute("UserForm",user);
        return "new_user";
    }

    @RequestMapping(value = "/saveUser",method = RequestMethod.POST)
    public String saveUser(@ModelAttribute("CustomerForm") User user) {
        userService.createUser(user);
        return "redirect:/allUsers";
    }
}
