package com.emlakjet.invoiceservice.repository;


import com.emlakjet.invoiceservice.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Long> {
}