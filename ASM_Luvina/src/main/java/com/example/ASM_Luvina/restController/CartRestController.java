package com.example.ASM_Luvina.restController;

import com.example.ASM_Luvina.entity.Cart;
import com.example.ASM_Luvina.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/cart")
public class CartRestController {
    @Autowired
    CartService service;
    @GetMapping("")
    public List<Cart> getCartList(){
        return service.getAll();
    }
    @PostMapping("/add")
    public Cart saveAndUpdate(@RequestBody Cart cart){
        return service.saveAngUpdate(cart);
    }
    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable("id") Integer id){
        service.delete(id);
    }
    @GetMapping("/getById/{id}")
    public Cart getCartById(@PathVariable("id") Integer id){
        return service.findById(id);
    }
}
