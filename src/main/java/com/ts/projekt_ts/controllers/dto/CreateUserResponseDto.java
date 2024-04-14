package com.ts.projekt_ts.controllers.dto;

import com.ts.projekt_ts.commonTypes.UserRole;

public class CreateUserResponseDto {
    private long id;
    private String name;
    private UserRole role;
    private String email;

    public CreateUserResponseDto(long id, String name, UserRole role, String email) {
        this.id = id;
        this.name = name;
        this.role = role;
        this.email = email;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public UserRole getRole() {
        return role;
    }

    public String getEmail() {
        return email;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setRole(UserRole role) {
        this.role = role;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
