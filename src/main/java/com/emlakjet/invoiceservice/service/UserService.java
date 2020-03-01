package com.emlakjet.invoiceservice.service;


import com.emlakjet.invoiceservice.entity.User;

public interface UserService {
    void save(User user);

    User findByUsername(String username);
}
