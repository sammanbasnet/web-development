package com.example.prj.service;
import com.example.prj.entity.Category;
import com.example.prj.entity.User;
import com.example.prj.pojo.CategoryPojo;
import com.example.prj.pojo.UserPojo;

import java.io.IOException;
import java.util.List;
import java.util.Optional;


public interface CategoryService {
    void saveCategory(CategoryPojo categoryPojo);

    List<Category> getAllData();

    Optional<Category> getById(Integer id);

    void deleteById(Integer id);
}
