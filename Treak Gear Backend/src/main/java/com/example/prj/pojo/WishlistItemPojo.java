package com.example.prj.pojo;
import com.example.prj.entity.Item;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;



@Getter
@Setter
public class WishlistItemPojo {
    private Integer id;
    @NotNull
    private Integer itemId;
    @NotNull
    private Integer userId;
}