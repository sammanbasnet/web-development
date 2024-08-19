package com.example.prj.entity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
@Table(name="category")


public class Category {
    @Id
    @SequenceGenerator(name = "category_seq_gen", sequenceName = "category_id_seq",allocationSize = 1)
    @GeneratedValue(generator="category_seq_gen", strategy = GenerationType.SEQUENCE)
    private Integer id;

    @Column(name="category_Name", nullable = false, length = 255)
    private String categoryName;

    @Column(name="category_Description", nullable = false, length = 255)
    private String categoryDescription;



}
