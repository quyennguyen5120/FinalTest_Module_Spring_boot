package com.example.test_spring_boot.Service;

import com.example.test_spring_boot.Dto.CategoryDto;

public interface CategoryService {
    CategoryDto createOrUpdate(CategoryDto categoryDto);
}
