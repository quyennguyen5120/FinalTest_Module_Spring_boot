package com.example.test_spring_boot.Repository;

import com.example.test_spring_boot.Entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, Long> {
    @Query("select u from UserEntity u where u.username = ?1")
    UserEntity getByUsername(String username);
}
