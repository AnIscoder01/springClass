package com.example.springfirst1.Controllers;

import com.example.springfirst1.Services.ProductService;
import com.example.springfirst1.Services.ProviderService;
import com.example.springfirst1.entity.Product;
import com.example.springfirst1.entity.Provider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class ProductController {


    @Autowired
    ProductService productService;

    @Autowired
    ProviderService providerService;

    @RequestMapping("/addProduct")
    public String addProduct(Model model) {

        Product product = new Product();

        List<Provider> providers = providerService.getAllProviders();

        model.addAttribute("ProductForm",product);
        model.addAttribute("listProvider",providers);
        return "new_product";
    }

    @RequestMapping(value = "/saveProduct",method = RequestMethod.POST)
    public String saveProduct(@ModelAttribute("ProductForm") Product product) {
        productService.createProduct(product);
        return "redirect:/allProducts";
    }

    @RequestMapping("/allProducts")
    public String listProducts(Model model) {
        List<Product> listProducts = productService.getAllProducts();
        model.addAttribute("listProducts", listProducts);

        return "liste_products";
    }

    @GetMapping("/delete/{id}")
    public String deleteProduct(@PathVariable int id) {
        productService.deleteProduct(id);
        return "redirect:/allProducts";
    }
    @GetMapping("edit/{id}")
    public String editProduct(@PathVariable int id, Model model) {
        Product product = productService.getProductById(id);
        model.addAttribute("product",product);
        return "update_product";
    }

    @PostMapping("/update/{id}")
    public String updateProduct(@PathVariable int id, Product product) {
        productService.updateProduct(product);
        return "redirect:/allProducts";
    }


}
