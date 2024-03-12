package com.example.midtermproj.models;

import lombok.Getter;
import lombok.Setter;
import org.springframework.web.bind.annotation.RestController;

@Setter
@Getter
@RestController
public class Product {
    private Long id;
    private String title;
    private String description;
    private double price;
    private Category category;
    private String imageUrl;

    public Product() {
    }

    public Product(long id, String title, String description, double price, Category category, String imageUrl) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.price = price;
        this.category = category;
        this.imageUrl = imageUrl;
    }

}
