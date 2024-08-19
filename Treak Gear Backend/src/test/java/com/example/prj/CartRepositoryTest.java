package com.example.prj;

import com.example.prj.entity.*;
import com.example.prj.repository.*;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

import java.util.List;
import java.util.Optional;


@DataJpaTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class CartRepositoryTest {
    @Autowired
    private CartRepository cartRepository;

    @Autowired
    private ItemRepository itemRepository;

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private BrandRepository brandRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    @Test
    @org.junit.jupiter.api.Order(1)
    @Rollback(value = false)
    public void saveCart(){
        Brand brand = new Brand();
        brand.setBrandName("BrandName");
        brand.setBrandDescription("brandsecriptiom");
        brandRepository.save(brand);
        Category category = new Category();
        category.setCategoryName("CategoryName");
        category.setCategoryDescription("categorydsecriptiom");
        categoryRepository.save(category);
        User user = new User();
        user.setFirstName("Niraj");
        user.setLastName("Giri");
        user.setEmail("niraj@gmail.com");
        user.setPassword("niraj123");
        user=userRepository.save(user);
        Item item = new Item();
        item.setItemName("item");
        item.setItemPerPrice(1000);
        item.setItemImage("image");
        item.setItemDescription("Description");
        item.setItemQuantity(20);
        item.setBrand(brand);
        item.setCategory(category);
        item=itemRepository.save(item);
        Cart cart = new Cart();
        cart.setQuantity(1);
        cart.setColor("lightblue");
        cart.setSize("S");
        cart.setItem(item);
        cart.setUser(user);
        cart=cartRepository.save(cart);
        Assertions.assertThat(cart.getId()).isGreaterThan(0);
    }
    @Test
    @org.junit.jupiter.api.Order(2)
    public void findById(){
        Cart cart=cartRepository.findById(1).get();
        Assertions.assertThat(cart.getId()).isEqualTo(1);
    }

    @Test
    @org.junit.jupiter.api.Order(3)
    public void findAllData(){
        List<Cart> cartList=cartRepository.findAll();
        Assertions.assertThat(cartList.size()).isGreaterThan(0);
    }

    @Test
    @org.junit.jupiter.api.Order(4)
    public void updateCart(){
        Cart cart=cartRepository.findById(1).get();
        cart.setQuantity(5);
        cart=cartRepository.save(cart);
        Assertions.assertThat(cart.getQuantity()).isEqualTo(5);

    }

    @Test
    @org.junit.jupiter.api.Order(5)
    public <cart> void deleteById(){
        cartRepository.deleteById(1);
        cart cart1=null;
        Optional<Cart> cart=cartRepository.findById(1);
        if(cart.isPresent()){
            cart1= (cart) cart.get();
        }
        Assertions.assertThat(cart1).isNull();
    }

}