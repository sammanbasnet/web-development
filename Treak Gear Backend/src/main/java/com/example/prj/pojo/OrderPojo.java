package com.example.prj.pojo;

import jakarta.persistence.Column;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.sql.Date;
import java.sql.Time;

@Getter
@Setter
public class OrderPojo {
    private Integer id;
    private Integer itemId;
    private Integer userId;
    private String deliveryDate;
    private String deliveryTime;
    private String deliveryStatus;
    private String Color;
    private String Size;
    private Integer Quantity;
}
