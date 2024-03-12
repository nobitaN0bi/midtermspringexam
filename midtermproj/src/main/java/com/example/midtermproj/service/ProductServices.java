package com.example.midtermproj.service;

import com.example.midtermproj.models.Product;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;
@Repository
public interface ProductServices {
    public List<Product>  getProducts();
    public Product getProduct(Long id);
    public Product addProduct(Product product);
    public Product updateProduct(Product product);
    public void deleteProduct(Long id);
    public List<Product> getProductsByCategory(String categoryName);
    public List<String> getCategories();
    public List<Product> getLimitedProducts(int limit);
    public List<Product> getSortedProducts(String sort);

}
