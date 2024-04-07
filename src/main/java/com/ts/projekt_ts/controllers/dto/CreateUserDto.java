package com.ts.projekt_ts.controllers.dto;

public class CreateUserDto {
    private String username;
    private String name;
    private String role;
    private String email;

    public CreateUserDto(String username, String name, String role, String email) {
        this.username = username;
        this.name = name;
        this.role = role;
        this.email = email;
    }

    public CreateUserDto() {
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

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}

