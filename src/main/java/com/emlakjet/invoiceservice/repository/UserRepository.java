package com.emlakjet.invoiceservice.repository;

import com.emlakjet.invoiceservice.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

    User findByUsername(String username);
}