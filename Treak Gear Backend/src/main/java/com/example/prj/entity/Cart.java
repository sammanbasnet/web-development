package com.example.prj.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
@Table(name="cart_items")
public class Cart {
    @Id
    @SequenceGenerator(name = "cart_item_seq_gen", sequenceName = "cart_item_id_seq", allocationSize = 1)
    @GeneratedValue(generator = "cart_item_seq_gen", strategy = GenerationType.SEQUENCE)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "item_id", nullable = false)
    private Item item;

    private String itemImage;

    @Column(name="color", nullable = false, length = 255)
    private String Color;

    @Column(name="size", nullable = false, length = 255)
    private String Size;

    @Column(name="Quantity", nullable = false, length = 255)
    private Integer Quantity;
    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;
}