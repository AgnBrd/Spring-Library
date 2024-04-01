package com.ts.projekt_ts.infrastucture.entity;

import com.ts.projekt_ts.commonTypes.UserRole;
import jakarta.persistence.*;

@Entity
@Table(name = "auth", schema = "library_ts")
public class AuthEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private long id;

    @Basic
    @Column(name = "username", unique = true, nullable = false)
    private String username;

    @Basic
    @Column(name = "password", nullable = false)
    private String password;

    @Enumerated(EnumType.STRING)
    @Column(name = "role", nullable = false)
    private UserRole role;

    @OneToOne
    @JoinColumn(name = "user_id", nullable = false)
    private UserEntity user;

    public AuthEntity(long id, String username, String password, UserRole role, UserEntity user) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.role = role;
        this.user = user;
    }

    public AuthEntity() {
    }

    public long getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public UserRole getRole() {
        return role;
    }

    public UserEntity getUser() {
        return user;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setRole(UserRole role) {
        this.role = role;
    }

    public void setUser(UserEntity user) {
        this.user = user;
    }
}


