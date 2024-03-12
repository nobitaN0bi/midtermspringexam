package com.example.midtermproj.service;
import com.example.midtermproj.dtos.fakeStoreCartDTO;
import com.example.midtermproj.dtos.fakeStoreProductDTO;
import com.example.midtermproj.dtos.fakeStoreProductDTO;
import com.example.midtermproj.models.Cart;
import com.example.midtermproj.models.Category;
import com.example.midtermproj.models.Product;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;
@Configuration
public  class fakeStoreCartServices {
    private final String url="https://fakestoreapi.com/carts";
    private final RestTemplate restTemplate=new RestTemplate();

    public Product getCart(Long id) {

        fakeStoreCartDTO fakeStoreProduct =  restTemplate.getForObject(
                "https://fakestoreapi.com/cart/" + id,
                fakeStoreProductDTO.class);
        Cart cart=new Cart();
        Cart.setID(fakeStoreProduct.getId());
        cart.setuserID(fakeStoreProduct.getuserID());
        cart.setDate(fakeStoreProduct.getDate());
        cart.setPrice(fakeStoreProduct.getPrice());
        cart.setImageUrl(fakeStoreProduct.getImageUrl());
        cart.setCategory(new Category());
        cart.getCategory().setName(fakeStoreProduct.getCategory());

        return product;
    }

    public Cart getCartById(Long id) {

        fakeStoreCartDTO fakeStoreProduct =  restTemplate.getForObject(
                "https://fakestoreapi.com/products/" + id,
                fakeStoreProductDto.class);

        Product product = new Product();
        product.setId(fakeStoreProduct.getId());
        product.setName(fakeStoreProduct.getTitle());
        product.setDescription(fakeStoreProduct.getDescription());
        product.setPrice(fakeStoreProduct.getPrice());
        product.setImageUrl(fakeStoreProduct.getImageUrl());
        product.setCategory(new Category());
        product.getCategory().setName(fakeStoreProduct.getCategory());

        return product;

    public List<Cart> Carts() {
        fakeStoreProductDTO[] fakeStoreProducts = restTemplate.getForObject(
                "https://fakestoreapi.com/carts/",
                fakeStoreProductDTO[].class);

        List<Product> products = new ArrayList<>();
        for (fakeStoreProductDTO fakeStoreProduct : fakeStoreProducts) {
            Product product = new Product();
            product.setId(fakeStoreProduct.getId());
            product.setName(fakeStoreProduct.getTitle());
            product.setDescription(fakeStoreProduct.getDescription());
            product.setPrice(fakeStoreProduct.getPrice());
            product.setImageUrl(fakeStoreProduct.getImageUrl());
            product.setCategory(new Category());
            product.getCategory().setName(fakeStoreProduct.getCategory());
            products.add(product);
        }
        return products;
    }

    public Product createProduct(Product product) {
        fakeStoreProductDTO fakeStoreProduct = new fakeStoreProductDTO();
        fakeStoreProduct.setTitle(product.getName());
        fakeStoreProduct.setDescription(product.getDescription());
        fakeStoreProduct.setPrice(product.getPrice());
        fakeStoreProduct.setImageUrl(product.getImageUrl());
        fakeStoreProduct.setCategory(product.getCategory().getName());

        fakeStoreProductDTO createdFakeStoreProduct = restTemplate.postForObject(
                "https://fakestoreapi.com/carts/",
                fakeStoreProduct,
                fakeStoreProductDTO.class);

        return product;
    }

    public Product updateProduct(Product product, Long id) {
        fakeStoreProductDTO fakeStoreProduct = new fakeStoreProductDTO();
        fakeStoreProduct.setTitle(product.getName());
        fakeStoreProduct.setDescription(product.getDescription());
        fakeStoreProduct.setPrice(product.getPrice());
        fakeStoreProduct.setImageUrl(product.getImageUrl());
        fakeStoreProduct.setCategory(product.getCategory().getName());

        restTemplate.put(
                "https://fakestoreapi.com/carts/" + id,
                fakeStoreProduct);

        return product;
    }

    public Cart deleteProduct(Long id) {
        Cart cart = getCartById(id);
        restTemplate.delete("https://fakestoreapi.com/cartsts/" + id);
        return cart;
    }

}
