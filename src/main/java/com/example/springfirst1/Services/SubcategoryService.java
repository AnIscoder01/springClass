package com.example.springfirst1.Services;

import com.example.springfirst1.Repository.SubcategoryRepository;
import com.example.springfirst1.entity.Subcategory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SubcategoryService {
    @Autowired
    SubcategoryRepository subcategoryRepository;

    public Subcategory createSubcategory(Subcategory subcategory) {
        return subcategoryRepository.save(subcategory);
    }

    public List<Subcategory> getAllSubcategories() {
        return subcategoryRepository.findAll();
    }
    public Subcategory getSubcategoryById(int id) {
        return subcategoryRepository.findById(id).get();
    }
    public Subcategory updateSubcategory(Subcategory subcategory) {
        return subcategoryRepository.saveAndFlush(subcategory);
    }
    public void deleteSubcategoryById(int id) {
        subcategoryRepository.deleteById(id);
    }
}
