package com.example.prj.service;


import com.example.prj.entity.Cart;
import com.example.prj.entity.WishlistItem;
import com.example.prj.pojo.CartPojo;

import java.util.List;
import java.util.Optional;

public interface CartService {

    void saveCart(CartPojo cartPojo);

    List<Cart> findAll();

    Optional<Cart> findById(Integer id);

    void deleteById(Integer id);

    List<Cart> findByUserId(Integer userId);

}


