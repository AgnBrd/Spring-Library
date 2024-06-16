package com.ts.projekt_ts.controllers.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;

public class RegisterDto {

    @NotBlank(message = "Username is required")
    @Schema(name = "username", example = "username")
    private String username;

    @NotBlank(message = "Password is required")
    @Schema(name = "password", example = "password")
    private String password;

//    @NotBlank(message = "Email is required")
//    @Schema(name = "email", example = "email")
//    private String email;

    public RegisterDto(String username, String password) {
        this.username = username;
        this.password = password;
//        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public String getUsername() {
        return username;
    }

//    public String getEmail() {
//        return email;
//    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

//    public void setEmail(String email) {
//        this.email = email;
//    }
}
