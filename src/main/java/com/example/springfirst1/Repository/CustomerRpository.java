package com.example.springfirst1.Repository;

import com.example.springfirst1.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRpository extends JpaRepository<Customer,Integer> {

}
