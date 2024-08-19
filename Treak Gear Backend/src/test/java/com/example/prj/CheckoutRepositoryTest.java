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
public class CheckoutRepositoryTest {
    @Autowired
    private OrderRepository orderRepository;

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
    public void saveOrder(){
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
        Order order = new Order();
        order.setQuantity(1);
        order.setDeliveryStatus("pending");
        order.setDeliveryTime("12:24");
        order.setDeliveryDate("2024/02/29");
        order.setItem(item);
        order.setUser(user);
        order=orderRepository.save(order);
        Assertions.assertThat(order.getId()).isGreaterThan(0);
    }
    @Test
    @org.junit.jupiter.api.Order(2)
    public void findById(){
        Order order=orderRepository.findById(1).get();
        Assertions.assertThat(order.getId()).isEqualTo(1);
    }

    @Test
    @org.junit.jupiter.api.Order(3)
    public void findAllData(){
        List<Order> orderList=orderRepository.findAll();
        Assertions.assertThat(orderList.size()).isGreaterThan(0);
    }

    @Test
    @org.junit.jupiter.api.Order(4)
    public void updateOrder(){
        Order order=orderRepository.findById(1).get();
        order.setQuantity(5);
        order=orderRepository.save(order);
        Assertions.assertThat(order.getQuantity()).isEqualTo(5);

    }

    @Test
    @org.junit.jupiter.api.Order(5)
    public <order> void deleteById(){
        orderRepository.deleteById(1);
        order order1=null;
        Optional<Order> order=orderRepository.findById(1);
        if(order.isPresent()){
            order1= (order) order.get();
        }
        Assertions.assertThat(order1).isNull();
    }

}