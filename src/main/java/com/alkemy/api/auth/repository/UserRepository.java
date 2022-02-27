package com.alkemy.api.auth.repository;

import com.alkemy.api.auth.filter.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, Long> {
     UserEntity findByUserName(String username);
    }

