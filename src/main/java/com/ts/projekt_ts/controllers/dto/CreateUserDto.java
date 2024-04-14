package com.ts.projekt_ts.controllers.dto;

import com.ts.projekt_ts.commonTypes.UserRole;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class CreateUserDto {
    private String name;
    @NotNull(message = "Role is required")
    private UserRole role;
    @NotBlank(message = "Email is required")
//    @Email
    private String email;

    public CreateUserDto(String name, UserRole role, String email) {
        this.name = name;
        this.role = role;
        this.email = email;
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

