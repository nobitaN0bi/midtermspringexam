package com.example.midtermproj.service;

import com.example.midtermproj.models.Cart;
import com.example.midtermproj.models.Product;

import java.util.Date;
import java.util.List;

public interface CartServices {
    public List<Cart> Carts();
    public Cart getCart(Long id);
    public Cart addCart(Cart cart);
    public Cart updateCart(Cart cart);
    public void deleteCart(Long id);
    public List<Cart> getCartByDate(Date date);
}
