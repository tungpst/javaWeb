package com.example.ASM_Luvina.dto;

import com.example.ASM_Luvina.entity.Product;
import lombok.Data;

@Data
public class CartDTO {
    private int idCart;
    private Product product;
    private int quantity;
}
