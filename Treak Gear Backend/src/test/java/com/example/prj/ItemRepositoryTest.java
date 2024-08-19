package com.example.prj;

import com.example.prj.config.PasswordEncoderUtil;
import com.example.prj.entity.Brand;
import com.example.prj.entity.Category;
import com.example.prj.entity.Item;
import com.example.prj.entity.User;
import com.example.prj.repository.BrandRepository;
import com.example.prj.repository.CategoryRepository;
import com.example.prj.repository.ItemRepository;
import jakarta.transaction.Transactional;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

import java.util.List;
import java.util.Optional;

@DataJpaTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class ItemRepositoryTest {

    @Autowired
    private ItemRepository itemRepository;

    @Autowired
    private BrandRepository brandRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    @Test
    @Order(1)
    @Rollback(value = false)
    @Transactional
    public void saveItem() {
        // Given
        Brand brand = new Brand();
        brand.setBrandName("BrandName");
        brand.setBrandDescription("brandsecriptiom");
        brandRepository.save(brand);
        Category category = new Category();
        category.setCategoryName("CategoryName");
        category.setCategoryDescription("categorydsecriptiom");
        categoryRepository.save(category);
        Item item = new Item();
        item.setItemName("Niraj");
        item.setItemPerPrice(1000);
        item.setItemImage("image");
        item.setItemDescription("Description");
        item.setItemQuantity(20);
        item.setBrand(brand);
        item.setCategory(category);
        item=itemRepository.save(item);

        // Then
        Assertions.assertThat(item.getId()).isGreaterThan(0);
    }


    @Test
    @Order(2)
    public void findById(){
        Item item=itemRepository.findById(1).get();
        Assertions.assertThat(item.getId()).isEqualTo(1);
    }
    @Test
    @Order(3)
    public void findAllData(){
        List<Item> itemList=itemRepository.findAll();
        Assertions.assertThat(itemList.size()).isGreaterThan(0);
    }
    @Test
    @Order(4)
    public void updateItem(){
        Item item=itemRepository.findById(1).get();
        item.setItemName("plant2");
        item=itemRepository.save(item);
        Assertions.assertThat(item.getItemName()).isEqualTo("plant2");

    }

    @Test
    @Order(5)
    public void deleteById(){
        itemRepository.deleteById(1);
        Item item1=null;
        Optional<Item> item=itemRepository.findById(1);
        if(item.isPresent()){
            item1=item.get();
        }
        Assertions.assertThat(item1).isNull();
    }
}