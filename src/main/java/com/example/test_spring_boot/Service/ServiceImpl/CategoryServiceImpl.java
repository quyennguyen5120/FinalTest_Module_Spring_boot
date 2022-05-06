package com.example.test_spring_boot.Service.ServiceImpl;

import com.example.test_spring_boot.Dto.CategoryDto;
import com.example.test_spring_boot.Entity.CategoryEntity;
import com.example.test_spring_boot.Repository.CategoryRepository;
import com.example.test_spring_boot.Service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    CategoryRepository categoryRepository;

    @Override
    public CategoryDto createOrUpdate(CategoryDto categoryDto) {
        CategoryEntity category = null;
        if(categoryDto.getId() != null){
            category = categoryRepository.findById(categoryDto.getId()).get();
        }
        if(category == null){
            category = new CategoryEntity();
        }
        category.setName(categoryDto.getName());
        return  new CategoryDto(categoryRepository.save(category));
    }
}
