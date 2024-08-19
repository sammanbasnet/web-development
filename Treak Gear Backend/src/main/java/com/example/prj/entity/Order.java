package com.example.prj.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.sql.Date;
import java.sql.Time;

@Getter
@Setter
@Entity
@Table (name = "orders")
public class Order {
    @Id
    @SequenceGenerator(name = "order_seq_gen", sequenceName = "order_id_seq",allocationSize = 1)
    @GeneratedValue(generator="order_seq_gen", strategy = GenerationType.SEQUENCE)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "item_id", nullable = false)
    private Item item;

    private String itemImage;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @Column(name="delivery_Date",length = 255)
    private String deliveryDate;

    @Column(name="delivery_Time")
    private String deliveryTime;

    @Column(name="delivery_Status", nullable = false)
    private String deliveryStatus;


    @Column(name="color", nullable = false, length = 255)
    private String Color;

    @Column(name="size", nullable = false, length = 255)
    private String Size;

    @Column(name="Quantity", nullable = false, length = 255)
    private Integer Quantity;

}

