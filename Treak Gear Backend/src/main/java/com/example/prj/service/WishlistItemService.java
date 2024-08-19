package com.example.prj.service;
import com.example.prj.entity.User;
import com.example.prj.pojo.UserPojo;

import com.example.prj.entity.WishlistItem;
import com.example.prj.pojo.WishlistItemPojo;
import java.util.List;
import java.util.Optional;

public interface WishlistItemService {

    void saveWishlistItem(WishlistItemPojo wishlistItemPojo);

    List<WishlistItem> findAll();


    Optional<WishlistItem> findById(Integer id);

    List<WishlistItem> findByUserId(Integer userId);


    void deleteById(Integer id);
}


