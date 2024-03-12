package com.example.midtermproj.dtos;

import com.example.midtermproj.models.Product;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.Date;

@Getter
@Setter
public class fakeStoreCartDTO {
    private Long id;
    private Long userID;
    private Date date;
    private ArrayList<Product> cart;

}
