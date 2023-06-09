package com.example.ASM_Luvina.repository;

import com.example.ASM_Luvina.entity.Items;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ItemsRepo extends JpaRepository<Items,Integer> {
    @Query("SELECT p FROM Items p WHERE p.product_id.id = :productID")
    Items findByProduct_id(int productID);

    @Query("SELECT p FROM Items p WHERE p.product_id.id = :productID and p.cart_id.id = :cartID")
    Items findByPrdIDAndIDCart(int productID, int cartID);
}
