package com.example.ASM_Luvina.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;
import java.util.Set;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "cart")
public class Cart {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private Date created_Date;
    @ManyToOne
    @JoinColumn(name = "user_id")
//    @JsonBackReference
    private User user_id;
    @OneToMany(mappedBy = "cart_id",cascade = CascadeType.ALL)
    private Set<Items> items;
}
