package com.example.prj.pojo;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;
import org.springframework.web.multipart.MultipartFile;

@Getter
@Setter

public class CategoryPojo {
    private Integer id;
    @NotEmpty
    private String categoryName;
    @NotEmpty
    private String categoryDescription;
}
