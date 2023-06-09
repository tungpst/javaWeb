package com.example.ASM_Luvina.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "items")
public class Items {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @ManyToOne
    @JoinColumn(name = "cart_id")
    private Cart cart_id;
    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product_id;
    private Integer quantity;
}
