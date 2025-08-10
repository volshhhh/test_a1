package com.example.unauthorizeddeliveries.repository;

import com.example.unauthorizeddeliveries.model.Login;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LoginRepository extends JpaRepository<Login, Long> {
    boolean existsByAppAccountNameAndIsActive(String appAccountName, Boolean isActive);
}