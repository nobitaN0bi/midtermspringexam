package com.example.midtermproj.controllers;

import com.example.midtermproj.models.Product;
import org.springframework.web.bind.annotation.*;
import com.example.midtermproj.service.ProductServices;

import java.util.List;

@SuppressWarnings("SpellCheckingInspection")
@RestController

public class ProductController {
    private ProductServices fakeproduct;

    public ProductController(ProductServices fakeproduct) {
        this.fakeproduct = fakeproduct;
    }

    @GetMapping("/product")
    public List<Product> getAllProducts() {
        return fakeproduct.getProducts();
    }

    @GetMapping("/product/categories")
    public List<String> getCategories() {
        return fakeproduct.getCategories();
    }

    @GetMapping("/product/limited/{limit}")
    public List<Product> getLimitedProducts(@PathVariable int limit) {
        return fakeproduct.getLimitedProducts(limit);
    }

    @GetMapping("/product/sorted")
    public List<Product> getSortedProducts(@RequestParam("order") String sort) {
        return fakeproduct.getSortedProducts(sort);
    }

    @GetMapping("/product/category/{categoryName}")
    public List<Product> getProductsByCategory(@PathVariable String categoryName) {
        return fakeproduct.getProductsByCategory(categoryName);
    }

    @GetMapping("/product/{id}")
    public Product getProduct(@PathVariable Long id) {
        return fakeproduct.getProduct(id);
    }

    @DeleteMapping("/product/delete/{id}")
    public String deleteProduct(@PathVariable Long id) {
        fakeproduct.deleteProduct(id);
        return "Product deleted successfully";
    }

    @PostMapping("/product/add")
    public Product addProduct(@RequestBody Product product) {
        return fakeproduct.addProduct(product);
    }

    @PutMapping("/product/update")
    public Product updateProduct(@RequestBody Product product) {
        return fakeproduct.updateProduct(product);
    }


}
