package com.example.springfirst1.Repository;

import com.example.springfirst1.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CategoryRpository extends JpaRepository<Category, Integer> {
    List<Category> findByTitle(String title);
}
