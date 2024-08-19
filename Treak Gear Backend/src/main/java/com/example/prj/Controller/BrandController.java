package com.example.prj.Controller;
import com.example.prj.entity.Brand;
import com.example.prj.entity.User;
import com.example.prj.pojo.BrandPojo;
import com.example.prj.pojo.UserPojo;
import com.example.prj.service.BrandService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RequestMapping("/brand")
@RestController
@RequiredArgsConstructor

public class BrandController {
    private final BrandService brandService;

    @PostMapping("/save")
    public String saveBrand(@Valid @RequestBody BrandPojo brandPojo){
        brandService.saveBrand(brandPojo);
        return "data created successfully";
    }

    @GetMapping("/getAll")
    public List<Brand> getAllData(){
        return brandService.getAllData();
    }

    @GetMapping("/getById/{id}")
    public Optional<Brand> getDataBtId(@PathVariable("id") Integer id){
        return brandService.getById(id);
    }

    @DeleteMapping("/deleteById/{id}")
    public void deleteById(@PathVariable("id") Integer id){
        brandService.deleteById(id);
    }

    @GetMapping("/searchByName/{brandName}")
    public List<Brand> searchByName(@PathVariable("brandName") String brandName) {
        return brandService.searchByName(brandName);
    }

}
