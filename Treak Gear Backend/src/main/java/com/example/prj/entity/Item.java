package com.example.prj.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
@Table(name="items")
public class Item {
    @Id
    @SequenceGenerator(name = "item_seq_gen", sequenceName = "item_id_seq",allocationSize = 1)
    @GeneratedValue(generator="item_seq_gen", strategy = GenerationType.SEQUENCE)
    private Integer id;

    @Column(name="item_Name", nullable = false, length = 255)
    private String itemName;

    @Column(name="item_Image", nullable = false, length = 255)
    private String itemImage;

    @Column(name="item_Description", nullable = false, length = 255)
    private String itemDescription;

    @Column(name="item_Quantity", nullable = false)
    private Integer itemQuantity;

    @Column(name="item_per_price", nullable = false)
    private Integer itemPerPrice;

    @ManyToOne
    @JoinColumn(name = "brand_id", nullable = false)
    private Brand brand;

    @ManyToOne
    @JoinColumn(name = "category_id", nullable = false)
    private Category category;


}
