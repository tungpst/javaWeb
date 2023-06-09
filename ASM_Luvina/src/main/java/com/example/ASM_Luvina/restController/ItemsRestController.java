package com.example.ASM_Luvina.restController;

import com.example.ASM_Luvina.dto.CartDTO;
import com.example.ASM_Luvina.entity.Items;
import com.example.ASM_Luvina.repository.ItemsRepo;
import com.example.ASM_Luvina.service.ItemsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/shopping")
public class ItemsRestController {
    @Autowired
    private ItemsService addToCartService;
    @Autowired
    private ItemsRepo itemsRepo;
    @GetMapping("")
    public List<Items> getAll(){
        return itemsRepo.findAll();
    }
    @PostMapping("/add")
    public ResponseEntity<Items> addToCart (@RequestBody CartDTO cartDTO){
        Items productItem = addToCartService.addToCart(cartDTO);
        if(productItem == null){
            throw new IllegalStateException("Thêm sản phẩm vào giỏ hàng thất bại");
        }
        return ResponseEntity.ok(productItem);
    }
    @PutMapping("/edit/{id}")
    public ResponseEntity<Items> editProduct(@RequestBody CartDTO cartDTO, @PathVariable int id){
        Items prdItem = addToCartService.editToCart(cartDTO,id);
        if(prdItem == null){
            throw new IllegalStateException("Sửa số lượng sản phẩm thất bại");
        }
        return ResponseEntity.ok(prdItem);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteProductToCart(@PathVariable int id){
        Boolean result = addToCartService.deleteProductToCart(id);
        String msg;
        if (result){
            msg = "xoá sản phẩm khỏi giỏ hàng thành công";
            return ResponseEntity.ok(msg);
        }
        return ResponseEntity.ok("Xoá sản phẩm thất bại");
    }
}
