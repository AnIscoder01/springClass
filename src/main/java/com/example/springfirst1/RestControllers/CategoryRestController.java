package com.example.springfirst1.RestControllers;

import com.example.springfirst1.Services.CategoryService;
import com.example.springfirst1.entity.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/category")
public class CategoryRestController {
    @Autowired
    CategoryService categoryService;

    @PostMapping("/save")
    public Category createCategory(@RequestBody Category category) {
        return categoryService.createCategory(category);
    }

    @GetMapping("/all")
    public List<Category> getAllCategories() {
        return categoryService.getAllCategories();
    }

    @GetMapping("/getOne/{id}")
    public Category getCategory(@PathVariable int id) {
        return categoryService.getCategoryById(id);
    }

    @PutMapping("/update/{id}")
    public Category updateCategory(@PathVariable int id, @RequestBody Category category) {
        Category existingCategory = categoryService.getCategoryById(id);

        if (existingCategory != null) {
            category.setId(id);
            return categoryService.updateCategory(category);
        } else {
            throw new RuntimeException("Category not found");
        }
    }

    @DeleteMapping("/delete/{id}")
    public void deleteCategory(@PathVariable int id) {
        categoryService.deleteCategory(id);
    }
}
