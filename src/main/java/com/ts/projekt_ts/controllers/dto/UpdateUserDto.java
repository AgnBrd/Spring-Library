package com.ts.projekt_ts.controllers.dto;

import com.ts.projekt_ts.commonTypes.UserRole;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class UpdateUserDto {
    private String username;
    private String name;
    private UserRole role;
    private String password;
//    @Email
    private String email;

    public UpdateUserDto(String username, String name, UserRole role, String password, String email) {
        this.username = username;
        this.name = name;
        this.role = role;
        this.password = password;
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public String getName() {
        return name;
    }

    public UserRole getRole() {
        return role;
    }

    public String getPassword() {
        return password;
    }

    public String getEmail() {
        return email;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setName(String name) {
        this.name = name;
    }

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
