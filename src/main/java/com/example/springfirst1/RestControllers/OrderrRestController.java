package com.example.springfirst1.RestControllers;

import com.example.springfirst1.Services.OrderrService;
import com.example.springfirst1.entity.Orderr;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/orderr")
public class OrderrRestController {
    @Autowired
    OrderrService orderrService;

    @PostMapping("/save")
    public Orderr createOrderr(@RequestBody Orderr orderr) {
        return orderrService.createOrderr(orderr);
    }

    @GetMapping("/all")
    public List<Orderr> getAllOrders() {
        return orderrService.getAllOrderr();
    }

    @GetMapping("/getOne/{id}")
    public Orderr getOrderr(@PathVariable int id) {
        return orderrService.getOrderrById(id);
    }

    @PutMapping("/update/{id}")
    public Orderr updateOrderr(@PathVariable int id, @RequestBody Orderr orderr) {
        Orderr existingOrderr = orderrService.getOrderrById(id);

        if (existingOrderr != null) {
            orderr.setId(id);
            return orderrService.updateOrderr(orderr);
        } else {
            throw new RuntimeException("Orderr not found");
        }
    }

    @DeleteMapping("/delete/{id}")
    public void deleteOrderr(@PathVariable int id) {
        orderrService.deleteOrderr(id);
    }
}
