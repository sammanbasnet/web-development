package com.example.prj.service.impl;
import com.example.prj.repository.BrandRepository;
import com.example.prj.repository.CategoryRepository;

import com.example.prj.entity.Item;
import com.example.prj.pojo.ItemPojo;
import com.example.prj.repository.ItemRepository;
import com.example.prj.service.ItemService;
import com.example.prj.util.ImageToBase64;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import com.example.prj.entity.Brand;
import com.example.prj.entity.Category;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.stream.Collectors;



@Service
@RequiredArgsConstructor
public class ItemServiceImpl implements ItemService {

    private final ItemRepository itemRepository;
    private final BrandRepository brandRepository;
    private final CategoryRepository categoryRepository;
    private final String UPLOAD_DIRECTORY = new StringBuilder().append(System.getProperty("user.dir")).append("/Trek_img/itemImage").toString();
    ImageToBase64 imageToBase64 = new ImageToBase64();
    @Override
    public void saveItem(ItemPojo itemPojo) throws IOException {
    Item item=new Item();


        if(itemPojo.getId()!=null){
            item=itemRepository.findById(itemPojo.getId())
                    .orElseThrow(()-> new NoSuchElementException("No data found"));
        }

        item.setItemName(itemPojo.getItemName());
        item.setItemDescription(itemPojo.getItemDescription());
        item.setItemQuantity(itemPojo.getItemQuantity());
        item.setItemPerPrice(itemPojo.getItemPerPrice());
        Brand brand = brandRepository.findByBrandName(itemPojo.getBrandName())
                .orElseThrow(() -> new NoSuchElementException("Brand not found"));

        Category category = categoryRepository.findByCategoryName(itemPojo.getCategoryName())
                .orElseThrow(() -> new NoSuchElementException("Category not found"));


        item.setBrand(brand);
        item.setCategory(category);



        if (itemPojo.getItemImage() != null) {
            StringBuilder fileNames = new StringBuilder();
            Path fileNameAndPath = Paths.get(UPLOAD_DIRECTORY, itemPojo.getItemImage().getOriginalFilename());
            fileNames.append(itemPojo.getItemImage().getOriginalFilename());
            Files.write(fileNameAndPath, itemPojo.getItemImage().getBytes());
        }


        item.setItemImage(itemPojo.getItemImage().getOriginalFilename());


            itemRepository.save(item);

    }

    @Override
    public List<Item> findAll() {
        List<Item> items = itemRepository.findAll();
        items = items.stream().map(item -> {
            item.setItemImage(imageToBase64.getImageBase64("/itemImage/" + item.getItemImage()));
            return item;
        }).collect(Collectors.toList());
        return items;
    }

    @Override
    public Optional<Item> findById(Integer id) {
        Optional<Item> optionalItem = itemRepository.findById(id);

        if (optionalItem.isPresent()) {
            Item item = optionalItem.get();
            String imagePath = "/itemImage/" + item.getItemImage();
            String base64Image = imageToBase64.getImageBase64(imagePath);

            if (base64Image == null) {
                // Handle the case where the image is not found, e.g., return an empty Optional
                return Optional.empty();
            }

            item.setItemImage(base64Image);
        }

        return optionalItem;
    }

    @Override
    public void deleteById(Integer id) {
           itemRepository.deleteById(id);
    }

    @Override
    public List<Item> searchByName(String itemName) {
        List<Item> items = itemRepository.findByItemNameIgnoreCase(itemName);
        items = items.stream().map(item -> {
            item.setItemImage(imageToBase64.getImageBase64("/itemImage/" + item.getItemImage()));
            return item;
        }).collect(Collectors.toList());
        return items;
    }

    @Override
    public List<Item> getItemsByBrandName(String brandName) {
        List<Item> items = itemRepository.getItemsByBrandBrandName(brandName);
        items = items.stream().map(item -> {
            item.setItemImage(imageToBase64.getImageBase64("/itemImage/" + item.getItemImage()));
            return item;
        }).collect(Collectors.toList());
        return items;

    }

    @Override
    public List<Item> getItemsByCategoryName(String categoryName) {
        List<Item> items = itemRepository.getItemsByCategoryCategoryName(categoryName);
        items = items.stream().map(item -> {
            item.setItemImage(imageToBase64.getImageBase64("/itemImage/" + item.getItemImage()));
            return item;
        }).collect(Collectors.toList());
        return items;

    }
}
