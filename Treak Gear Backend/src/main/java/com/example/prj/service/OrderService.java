package com.example.prj.service;


import com.example.prj.entity.Order;

import com.example.prj.pojo.OrderPojo;
import java.util.List;
import java.util.Optional;

public interface OrderService {

        void saveOrder(OrderPojo orderPojo);

        List<Order> findAll();

        Optional<Order> findById(Integer id);

        void deleteById(Integer id);
    }


