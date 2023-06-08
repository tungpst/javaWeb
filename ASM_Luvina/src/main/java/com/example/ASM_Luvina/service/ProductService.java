package com.example.ASM_Luvina.service;

import com.example.ASM_Luvina.entity.Product;
import com.example.ASM_Luvina.repository.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ProductService {

    @Autowired
    private ProductRepo repo;

    public List<Product> listAll() {
        return repo.findAll();
    }
    public Product add(Product product) {
        return repo.save(product);
    }

    public Product findById(int id) {
        return repo.findById(id).get();
    }

    public void delete(int id) {
        repo.deleteById(id);
    }


}
