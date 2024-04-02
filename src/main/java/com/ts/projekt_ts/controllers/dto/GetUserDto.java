package com.ts.projekt_ts.controllers.dto;

import com.ts.projekt_ts.commonTypes.UserRole;

public class GetUserDto {
    private long id;
    private String username;
    private String name;
    private UserRole role;
    private String email;

    public GetUserDto(long id, String username, String name, UserRole role, String email) {
        this.id = id;
        this.username = username;
        this.name = name;
        this.role = role;
        this.email = email;
    }

    public GetUserDto() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public UserRole getRole() {
        return role;
    }

    public void setRole(UserRole role) {
        this.role = role;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}

