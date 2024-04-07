package com.ts.projekt_ts.controllers.dto;

import com.ts.projekt_ts.commonTypes.UserRole;

public class RegisterDto {
    private String username;
    private String name;
    private UserRole role;
    private String password;
    private String email;

    public RegisterDto(String username, String name, String email, String password, UserRole role) {
        this.username = username;
        this.name = name;
        this.role = role;
        this.password = password;
        this.email = email;
    }

    public String getName() {return name;}

    public String getPassword() {
        return password;
    }

    public String getEmail() {
        return email;
    }

    public String getUsername() {
        return username;
    }


    public UserRole getRole() {
        return role;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setName(String name){this.name = name;}

    public void setRole(UserRole role) {
        this.role = role;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
