package com.example.test_spring_boot.Repository;

import com.example.test_spring_boot.Dto.ProductDto;
import com.example.test_spring_boot.Entity.ProductEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<ProductEntity,Long> {

    @Query("select p from ProductEntity p")
    Page<ProductEntity> getByPage(Pageable pageable);

    @Query("select new com.example.test_spring_boot.Dto.ProductDto(p) from ProductEntity p where p.id = ?1")
    ProductDto getDtoById(Long id);
}
