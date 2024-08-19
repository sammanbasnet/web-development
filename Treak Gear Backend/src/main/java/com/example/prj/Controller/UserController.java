package com.example.prj.Controller;

import com.example.prj.entity.User;
import com.example.prj.pojo.UserPojo;
import com.example.prj.service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@RequestMapping("/user")
@RestController
@RequiredArgsConstructor

public class UserController {

    private final UserService userService;

    @PostMapping("/save")
    public String saveUser(@Valid @RequestBody UserPojo userPojo){
        userService.saveUser(userPojo);
        return "data created successfully";
    }

    @GetMapping("/getAll")
    public List<User> getAllData(){
        return userService.getAllData();
    }

    @GetMapping("/getById/{id}")
    public Optional<User> getDataById(@PathVariable("id") Integer id){
        return userService.getById(id);
    }

    @DeleteMapping("/deleteById/{id}")
    public void deleteById(@PathVariable("id") Integer id){
        userService.deleteById(id);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<String> updateUser(@PathVariable("id") Integer id, @RequestBody UserPojo updatedUserDetails) {
        try {
            userService.updateUser(id, updatedUserDetails);
            return new ResponseEntity<>("User updated successfully", HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<>("User not found", HttpStatus.NOT_FOUND);
        }
    }

}
