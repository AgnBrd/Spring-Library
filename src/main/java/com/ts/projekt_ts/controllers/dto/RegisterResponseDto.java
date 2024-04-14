package com.ts.projekt_ts.controllers.dto;

public class RegisterResponseDto {
    private String username;

    public RegisterResponseDto(String username) {
        this.username = username;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

}
