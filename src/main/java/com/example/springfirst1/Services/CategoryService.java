package com.example.springfirst1.Services;

import com.example.springfirst1.Repository.CategoryRpository;
import com.example.springfirst1.Repository.ProductRepository;
import com.example.springfirst1.entity.Category;
import com.example.springfirst1.entity.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService {
    @Autowired
    CategoryRpository categoryRpository;

    public Category createCategory(Category category) {
        return categoryRpository.save(category);
    }

    public List<Category> getAllCategories() {
        return categoryRpository.findAll();
    }
    public Category getCategoryById(int id) {
        return categoryRpository.findById(id).get();
    }

    public Category updateCategory(Category category) {
        return categoryRpository.saveAndFlush(category);
    }

    public void deleteCategory(int id) {
        categoryRpository.deleteById(id);
    }
}
