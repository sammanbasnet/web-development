package com.example.prj.pojo;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;
import org.springframework.web.multipart.MultipartFile;

@Getter
@Setter
public class ItemPojo {

    private Integer id;
    @NotEmpty
    private String itemName;

    @NotNull
    private MultipartFile itemImage;
    @NotEmpty
    private String itemDescription;
    @NotNull
    private Integer itemQuantity;
    @NotNull
    private Integer itemPerPrice;
    @NotNull
    private String brandName;
    @NotNull
    private String categoryName;

}
