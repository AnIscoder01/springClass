package com.example.springfirst1.RestControllers;

import com.example.springfirst1.Services.SubcategoryService;
import com.example.springfirst1.entity.Subcategory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/subcategory")
public class SubcategoryRestController {
    @Autowired
    SubcategoryService subcategoryService;

    @PostMapping("/save")
    public Subcategory createSubcategory(@RequestBody Subcategory subcategory) {
        return subcategoryService.createSubcategory(subcategory);
    }

    @GetMapping("/all")
    public List<Subcategory> getAllSubcategories() {
        return subcategoryService.getAllSubcategories();
    }

    @GetMapping("/getOne/{id}")
    public Subcategory getSubcategory(@PathVariable int id) {
        return subcategoryService.getSubcategoryById(id);
    }

    @PutMapping("/update/{id}")
    public Subcategory updateSubcategory(@PathVariable int id, @RequestBody Subcategory subcategory) {
        Subcategory existingSubcategory = subcategoryService.getSubcategoryById(id);

        if (existingSubcategory != null) {
            subcategory.setId(id);
            return subcategoryService.updateSubcategory(subcategory);
        } else {
            throw new RuntimeException("Subcategory not found");
        }
    }

    @DeleteMapping("/delete/{id}")
    public void deleteSubcategory(@PathVariable int id) {
        subcategoryService.deleteSubcategoryById(id);
    }
}
