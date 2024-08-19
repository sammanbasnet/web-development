package com.example.prj.service;
import com.example.prj.entity.Brand;
import com.example.prj.entity.User;
import com.example.prj.pojo.BrandPojo;
import com.example.prj.pojo.UserPojo;

import java.io.IOException;
import java.util.List;
import java.util.Optional;


public interface BrandService {
    void saveBrand(BrandPojo brandPojo);

    List<Brand> getAllData();

    Optional<Brand> getById(Integer id);

    void deleteById(Integer id);
    List<Brand> searchByName(String brandName);
}
