package com.example.midtermproj.controllers;

import com.example.midtermproj.models.Cart;
import com.example.midtermproj.models.Product;
import com.example.midtermproj.service.CartServices;
import com.example.midtermproj.service.ProductServices;
import org.springframework.web.bind.annotation.*;

import java.util.List;

public class CartController {
    private CartServices fakeCart;

    public CartController(CartServices fakeCart) {
        this.fakeCart = fakeCart    ;
    }

    @GetMapping("/cart")
    public List<Cart> Carts() {
        return fakeCart.Carts();
    }


    @GetMapping("/cart/{id}")
    public Cart getCart(@PathVariable Long id) {
        return fakeCart.getCart(id);
    }

    @DeleteMapping("/cart/delete/{id}")
    public String deleteCart(@PathVariable Long id) {
        fakeCart.deleteCart(id);
        return "Cart deleted successfully";
    }

    @PostMapping("/cart/add")
    public Cart addCart(@RequestBody Cart Cart) {
        return fakeCart.addCart(Cart);
    }

    @PutMapping("/cart/update")
    public Cart updateCart(@RequestBody Cart Cart) {
        return fakeCart.updateCart(Cart);
    }

}
