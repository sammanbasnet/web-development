package com.example.prj.Controller;

import com.example.prj.entity.Cart;
import com.example.prj.entity.WishlistItem;
import com.example.prj.pojo.CartPojo;
import com.example.prj.service.CartService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RequestMapping("/cart")
@RestController
@RequiredArgsConstructor
public class CartController {
    private final CartService cartService;

    @PostMapping("/save")
    public String saveCart(@Valid @RequestBody CartPojo cartPojo){
        cartService.saveCart(cartPojo);
        return "data created successfully yoh cart-item";
    }
    @GetMapping("/getAll")
    public List<Cart> findAll(){
        return cartService.findAll();
    }

    @GetMapping("/getByUserId/{userId}")
    public List<Cart> findByUserId(@PathVariable("userId") Integer userId) {
        return cartService.findByUserId(userId);
    }

    @GetMapping("/getById/{id}")
    public Optional<Cart> findById(@PathVariable("id") Integer id){
        return cartService.findById(id);
    }

    @DeleteMapping("/deleteById/{id}")
    public void deleteById(@PathVariable("id") Integer id){
        cartService.deleteById(id);
    }
}


