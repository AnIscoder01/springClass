package com.example.springfirst1.RestControllers;

import com.example.springfirst1.Services.UserService;
import com.example.springfirst1.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserRestController {
    @Autowired
    UserService userService;

    @PostMapping("/save")
    public User createUser(@RequestBody User user) {
        return userService.createUser(user);
    }

    @GetMapping("/all")
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }

    @GetMapping("/getOne/{id}")
    public User getUser(@PathVariable int id) {
        return userService.getUserById(id);
    }

    @PutMapping("/update/{id}")
    public User updateUser(@PathVariable int id, @RequestBody User user) {
        User existingUser = userService.getUserById(id);

        if (existingUser != null) {
            user.setId(id);
            return userService.updateUser(user);
        } else {
            throw new RuntimeException("User not found");
        }
    }

    @DeleteMapping("/delete/{id}")
    public void deleteUser(@PathVariable int id) {
        userService.deleteUser(id);
    }
}
