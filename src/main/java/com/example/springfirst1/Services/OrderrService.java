package com.example.springfirst1.Services;

import com.example.springfirst1.Repository.OrderrRepository;
import com.example.springfirst1.entity.Orderr;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderrService {
    @Autowired
    OrderrRepository orderrRepository;

    public Orderr createOrderr(Orderr orderr) {
        return orderrRepository.save(orderr);
    }

    public List<Orderr> getAllOrderr() {
        return orderrRepository.findAll();
    }
    public Orderr getOrderrById(int id) {
        return orderrRepository.findById(id).get();
    }

    public Orderr updateOrderr(Orderr orderr) {
        return orderrRepository.saveAndFlush(orderr);
    }
    public void deleteOrderr(int id) {
        orderrRepository.deleteById(id);
    }
}
