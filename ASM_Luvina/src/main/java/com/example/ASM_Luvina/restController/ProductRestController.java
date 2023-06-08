package com.example.ASM_Luvina.restController;

import com.example.ASM_Luvina.entity.Product;
import com.example.ASM_Luvina.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/product")
public class ProductRestController {
    @Autowired
    ProductService productService;

    @GetMapping("")
    public List<Product> getALL() {
        return productService.listAll();
    }

    @GetMapping("/getByID/{id}")
    public Product getProdById(@PathVariable("id") int id) {
        Product pro = productService.findById(id);
        return pro;
    }
    @PostMapping("/add")
    public Product createProduct(@RequestBody Product pro)  {
           return productService.add(pro);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteProduct(@PathVariable("id") int id) {
       productService.delete(id);
    }
}