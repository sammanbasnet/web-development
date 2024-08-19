package com.example.prj.entity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
@Table(name="brand")


public class Brand {
    @Id
    @SequenceGenerator(name = "brand_seq_gen", sequenceName = "brand_id_seq",allocationSize = 1)
    @GeneratedValue(generator="brand_seq_gen", strategy = GenerationType.SEQUENCE)
    private Integer id;

    @Column(name="brand_Name", nullable = false, length = 255)
    private String brandName;

    @Column(name="brand_Description", nullable = false, length = 255)
    private String brandDescription;



}

