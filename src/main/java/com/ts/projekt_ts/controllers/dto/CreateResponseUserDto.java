package com.ts.projekt_ts.controllers.dto;

import com.ts.projekt_ts.commonTypes.UserRole;

public class CreateResponseUserDto {
    private long id;
    private String login;
    private String name;
    private UserRole role;
    private String email;

    public CreateResponseUserDto(long id, String login, String name, UserRole role, String email) {
        this.id = id;
        this.login = login;
        this.name = name;
        this.role = role;
        this.email = email;
    }

    public CreateResponseUserDto() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
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

