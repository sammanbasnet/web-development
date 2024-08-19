package com.example.prj.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
@Table(name="wishlist_items")
public class WishlistItem {
    @Id
    @SequenceGenerator(name = "wishlist_item_seq_gen", sequenceName = "wishlist_item_id_seq", allocationSize = 1)
    @GeneratedValue(generator = "wishlist_item_seq_gen", strategy = GenerationType.SEQUENCE)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "item_id", nullable = false)
    private Item item;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;
    private String itemImage;
}