package com.example.test_spring_boot.Repository;

import com.example.test_spring_boot.Entity.ProductHistory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductHistoryRepostiory extends JpaRepository<ProductHistory, Long> {
}
