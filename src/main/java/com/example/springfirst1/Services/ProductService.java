package com.example.springfirst1.Services;

import com.example.springfirst1.Repository.ProductRepository;
import com.example.springfirst1.entity.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {
    @Autowired
    ProductRepository productRepository;

    public Product createProduct(Product product) {

        return productRepository.save(product);
    }
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }
    public Product getProductById(int id) {
        return productRepository.findById(id).get();
    }
    public Product updateProduct(Product product) {
        return productRepository.saveAndFlush(product);
    }

    public void deleteProduct(int id) {
        productRepository.deleteById(id);
    }

}
