package com.example.ASM_Luvina.restController;

import com.example.ASM_Luvina.entity.Cart;
import com.example.ASM_Luvina.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/cart")
public class CartRestController {
    @Autowired
    CartService service;
    @GetMapping("/hien-thi")
    public List<Cart> getCartList(){
        return service.getAll();
    }
}
