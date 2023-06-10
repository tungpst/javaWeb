package com.example.ASM_Luvina.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "product")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private String color;
    private int quantity;
    private BigDecimal price;
    private String description;
    @OneToMany(mappedBy = "product_id",cascade = CascadeType.ALL)
    private Set<Items> items;
}
