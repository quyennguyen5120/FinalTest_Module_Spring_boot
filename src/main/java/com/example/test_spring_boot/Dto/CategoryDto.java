package com.example.test_spring_boot.Dto;

import com.example.test_spring_boot.Entity.CategoryEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CategoryDto {
    private Long id;
    private String name;
    private Date CreateDate;
    private String CreateBy;

    public CategoryDto(CategoryEntity categoryEntity){
        if(categoryEntity!= null){
            if(categoryEntity.getId() != null)
                this.id = categoryEntity.getId();
            if(categoryEntity.getName() != null)
                this.name = categoryEntity.getName();
            this.CreateDate = categoryEntity.getCreateDate();
            this.CreateBy = categoryEntity.getCreateBy();
        }
    }
}
