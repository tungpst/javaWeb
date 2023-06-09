package com.example.ASM_Luvina.service;

import com.example.ASM_Luvina.dto.CartDTO;
import com.example.ASM_Luvina.entity.Items;
import com.example.ASM_Luvina.entity.Product;
import com.example.ASM_Luvina.repository.CartRepo;
import com.example.ASM_Luvina.repository.ItemsRepo;
import com.example.ASM_Luvina.repository.ProductRepo;
import com.example.ASM_Luvina.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ItemsService {
    @Autowired
    private ItemsRepo productItemRepository;
    @Autowired
    private ProductRepo productRepo;
    @Autowired
    private CartRepo cartRepository;
    @Autowired
    private UserRepo userRepo;
    public Items addToCart(Product cartDTO){

        Items productItem = new Items();

        Product product = productRepo.findById(cartDTO.getId()).get();

        Items item = productItemRepository.findByProduct_id(product.getId());

        productItem.setCart_id(cartRepository.findById(1).get());

        if(product != null && item != null){
            productItem = item;
            System.out.println("Quantity: " + productItem.getQuantity());
            System.out.println("Quantity: " + item.getQuantity());
            productItem.setQuantity(productItem.getQuantity() + 1);
        }else {
            productItem.setProduct_id(product);
            productItem.setQuantity(1);
        }
        Items productItemSave = productItemRepository.save(productItem);
        if(productItemSave != null){
            return productItemSave;
        }
        return null;
    }
    public Items editToCart(CartDTO cartDTO, int idItemCart){
        Items productItem = productItemRepository.findById(idItemCart).get();

        Items item = productItemRepository.findByProduct_id(cartDTO.getProduct().getId());
        if (item != null){
            productItem.setQuantity(cartDTO.getQuantity());
            productItemRepository.save(productItem);
            return productItem;
        }
        return null;
    }
    public boolean deleteProductToCart(int idItemCart){
        Items productItem = productItemRepository.findById(idItemCart).get();
        if (productItem != null){
            productItemRepository.delete(productItem);
            return true;
        }
        return false;
    }
    public void deleteById(Integer id){
        productItemRepository.deleteById(id);
    }
    public Items save(Items items){
        return productItemRepository.save(items);
    }
}


