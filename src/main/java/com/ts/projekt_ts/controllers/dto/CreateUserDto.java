package com.ts.projekt_ts.controllers.dto;

import com.ts.projekt_ts.commonTypes.UserRole;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class CreateUserDto {
    @Schema(name = "name", example = "name")
    private String name;

    @NotNull(message = "Role is required")
    @Schema(name = "role", example = "ROLE_ADMIN")
    private UserRole role;

    @NotBlank(message = "Email is required")
    @Schema(name = "email", example = "email@gmail.com")
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
