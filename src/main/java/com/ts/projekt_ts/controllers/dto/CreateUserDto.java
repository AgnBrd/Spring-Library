package com.ts.projekt_ts.controllers.dto;

public class CreateUserDto {
    private String login;
    private String password;
    private String name;
    private String role;
    private String email;

    public CreateUserDto(String login, String password, String name, String role, String email) {
        this.login = login;
        this.password = password;
        this.name = name;
        this.role = role;
        this.email = email;
    }

    public CreateUserDto() {
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
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

