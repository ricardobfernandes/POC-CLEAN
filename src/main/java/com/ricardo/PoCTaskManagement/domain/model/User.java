package com.ricardo.PoCTaskManagement.domain.model;

import com.ricardo.PoCTaskManagement.domain.exception.InvalidUserInfoException;

public class User {

    private Long id;
    private String name;
    private String email;

    public User(Long id, String name, String email) {
        if (name == null || name.isBlank()) {
            throw new InvalidUserInfoException("User name is required");
        }
        if (email == null || email.isBlank()) {
            throw new InvalidUserInfoException("User email is required");
        }
        this.id = id;
        this.name = name;
        this.email = email;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }
}