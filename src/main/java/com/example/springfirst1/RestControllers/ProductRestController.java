package com.example.springfirst1.RestControllers;

import com.example.springfirst1.Services.ProductService;
import com.example.springfirst1.entity.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductRestController {
    @Autowired
    ProductService productService;

    @PostMapping("/save")
    public Product saveProduct(@RequestBody Product product) {
        return productService.createProduct(product);
    }

    @PostMapping("/save2")
    public ResponseEntity <Product> createProduct(@RequestBody Product product) {
        try{
            productService.createProduct(product);
            return new ResponseEntity<Product>(product, HttpStatus.CREATED);
        }catch (Exception e)
        {
            return new ResponseEntity<Product>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/all")
    public List<Product> getAllProducts() {
        return productService.getAllProducts();
    }

    @GetMapping("/all2")
    public ResponseEntity<List<Product>> getAllProducts2() {
        try {
            List<Product> products = productService.getAllProducts();
            if(products.isEmpty()){
                return new ResponseEntity<List<Product>>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<List<Product>>(products,HttpStatus.OK);
        }
        catch (Exception e){

            return new ResponseEntity<List<Product>>(HttpStatus.INTERNAL_SERVER_ERROR);

        }

    }


    @GetMapping("/getOne/{id}")
    public Product getProductById(@PathVariable int id) {
        return productService.getProductById(id);
    }

    @PutMapping("/update/{id}")
    public Product updateProduct(@RequestBody Product product, @PathVariable int id) {

        Product c1= productService.getProductById(id);
        if(c1!=null){
            product.setId(id);
            return productService.updateProduct(product);
        }
        else{
            throw new RuntimeException("failed");
        }
    }

    @DeleteMapping("/delete/{id}")
    public void deleteProduct(@PathVariable int id) {
        productService.deleteProduct(id);
    }
}
