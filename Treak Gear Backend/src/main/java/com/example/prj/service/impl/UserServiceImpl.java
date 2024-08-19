package com.example.prj.service.impl;

import com.example.prj.config.PasswordEncoderUtil;
import com.example.prj.entity.Role;
import com.example.prj.entity.User;
import com.example.prj.pojo.UserPojo;
import com.example.prj.repository.UserRepository;
import com.example.prj.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    @Override
    public void saveUser(UserPojo userPojo) {

        User user = new User();

        if(userPojo.getId()!=null){
            user=userRepository.findById(userPojo.getId())
                    .orElseThrow(()-> new NoSuchElementException("No data found"));
        }

        user.setFirstName(userPojo.getFirstName());
        user.setLastName(userPojo.getLastName());
        user.setEmail(userPojo.getEmail());
        user.setPassword(PasswordEncoderUtil.getInstance().encode(userPojo.getPassword()));


        userRepository.save(user);
    }

    @Override
    public List<User> getAllData() {
        return userRepository.findAll(); // select * from users
    }

    @Override
    public Optional<User> getById(Integer id) {
        return userRepository.findById(id);
    }

    @Override
    public void deleteById(Integer id) {
        userRepository.deleteById(id);
    }

    @Override
    public void updateUser(Integer id, UserPojo updatedUserDetails) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("User not found"));

        user.setFirstName(updatedUserDetails.getFirstName());
        user.setLastName(updatedUserDetails.getLastName());
        user.setEmail(updatedUserDetails.getEmail());

        userRepository.save(user);
    }
}
