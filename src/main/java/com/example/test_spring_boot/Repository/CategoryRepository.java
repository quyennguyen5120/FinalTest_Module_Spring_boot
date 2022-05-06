package com.example.test_spring_boot.Repository;

import com.example.test_spring_boot.Dto.CategoryDto;
import com.example.test_spring_boot.Entity.CategoryEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CategoryRepository extends JpaRepository<CategoryEntity, Long> {

    @Query("SELECT new com.example.test_spring_boot.Dto.CategoryDto(c) from CategoryEntity c")
    List<CategoryDto> getAllDto();
}
