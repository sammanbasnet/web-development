package com.example.prj.service.impl;

import com.example.prj.entity.Item;
import com.example.prj.entity.Cart;
import com.example.prj.entity.WishlistItem;
import com.example.prj.pojo.CartPojo;
import com.example.prj.repository.ItemRepository;
import com.example.prj.repository.CartRepository;
import com.example.prj.service.CartService;
import com.example.prj.util.ImageToBase64;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import com.example.prj.entity.User;
import com.example.prj.repository.UserRepository;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CartServiceImpl implements CartService {
    private final CartRepository cartRepository;
    private final ItemRepository itemRepository;
    private final UserRepository userRepository;
    ImageToBase64 imageToBase64 = new ImageToBase64();
    @Override
    public void saveCart(CartPojo cartPojo) {
        Cart cart=new Cart();
        if(cartPojo.getId()!=null){
            cart=cartRepository.findById(cartPojo.getId())
                    .orElseThrow(()-> new NoSuchElementException("No data found"));
        }
        cart.setColor(cartPojo.getColor());
        cart.setQuantity(cartPojo.getQuantity());
        cart.setSize(cartPojo.getSize());
        Item item=itemRepository.findById(cartPojo.getItemId()).get();
        User user=userRepository.findById(cartPojo.getUserId()).get();
        cart.setItem(item);
        cart.setUser(user);
        cartRepository.save(cart);
    }
    @Override
    public List<Cart> findAll() {
        return cartRepository.findAll().stream().map(item -> {
            item.setItemImage(imageToBase64.getImageBase64("/itemImage/" + item.getItem().getItemImage()));
            return item;
        }).collect(Collectors.toList());
    }
    @Override
    public List<Cart> findByUserId(Integer userId) {
        List<Cart> cartList = cartRepository.findByUserId(userId);
        return cartList.stream().map(item -> {
            item.setItemImage(imageToBase64.getImageBase64("/itemImage/" + item.getItem().getItemImage()));
            return item;
        }).collect(Collectors.toList());
    }
    @Override
    public Optional<Cart> findById(Integer id) {
        return cartRepository.findById(id);
    }
    @Override
    public void deleteById(Integer id) {
        cartRepository.deleteById(id);
    }


}
