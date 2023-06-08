package com.example.ASM_Luvina.service;

import com.example.ASM_Luvina.entity.Cart;
import com.example.ASM_Luvina.repository.CartRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CartService {
    @Autowired
    CartRepo cartRepo;
    public List<Cart> getAll(){
        return cartRepo.findAll();
    }
}
