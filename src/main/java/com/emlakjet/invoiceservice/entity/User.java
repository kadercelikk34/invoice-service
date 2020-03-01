package com.emlakjet.invoiceservice.entity;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;

@Entity
@Table(name = "USER")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotEmpty(message = "Please provide a username")
    @Column(name = "USERNAME")
    private String username;

    @NotEmpty(message = "Please provide a lastname")
    @Column(name = "LASTNAME")
    private String lastname;

    @NotEmpty(message = "Please provide a email")
    @Column(name = "EMAIL", unique = true)
    private String email;

    @NotEmpty(message = "Please provide a password")
    @Column(name = "PASSWORD")
    private String password;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
