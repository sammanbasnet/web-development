package com.example.prj.service;

import com.example.prj.entity.User;
import com.example.prj.pojo.UserPojo;

import java.util.List;
import java.util.Optional;

public interface UserService {

    void saveUser(UserPojo userPojo);

    List<User> getAllData();

    Optional<User> getById(Integer id);

    void deleteById(Integer id);
    void updateUser(Integer id, UserPojo updatedUserDetails);

}
