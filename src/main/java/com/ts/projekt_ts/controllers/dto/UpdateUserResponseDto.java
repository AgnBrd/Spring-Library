package com.ts.projekt_ts.controllers.dto;

import com.ts.projekt_ts.commonTypes.UserRole;

public class UpdateUserResponseDto {
    private long userId;
    private String username;
    private UserRole role;
    private String email;

    public UpdateUserResponseDto(long userId, String username, UserRole role, String email) {
        this.userId = userId;
        this.username = username;
        this.role = role;
        this.email = email;
    }

    public long getUserId() {return userId;}

    public String getUsername() {
        return username;
    }

    public UserRole getRole() {
        return role;
    }

    public String getEmail() {
        return email;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setRole(UserRole role) {
        this.role = role;
    }

    public void setEmail(String email) {
        this.email = email;
    }

}
