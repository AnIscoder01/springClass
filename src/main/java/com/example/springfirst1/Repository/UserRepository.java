package com.example.springfirst1.Repository;

import com.example.springfirst1.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {

}
