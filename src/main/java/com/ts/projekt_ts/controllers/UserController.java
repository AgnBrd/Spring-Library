package com.ts.projekt_ts.controllers;

import com.ts.projekt_ts.controllers.dto.*;
import com.ts.projekt_ts.infrastucture.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping

public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/api/users")
    @PreAuthorize("hasRole('EMPLOEE') || hasRole('ADMIN')")
    public List<GetUserDto> getAllUsers() {
        return userService.getAll();
    }

    @GetMapping("/api/users/{id}")
    @PreAuthorize("hasRole('EMPLOEE') || hasRole('ADMIN')")
    public GetUserDto getOne(@PathVariable long id) {
        return userService.getOne(id);
    }


    @DeleteMapping("/api/users/{id}")
    @PreAuthorize("hasRole('EMPLOEE') || hasRole('ADMIN')")
    public ResponseEntity<Void> delete(@PathVariable long id) {
        userService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @PostMapping("/api/users/register")
    public ResponseEntity<RegisterResponseDto> register(@Validated @RequestBody RegisterDto requestBody){
        RegisterResponseDto dto = userService.register(requestBody);
        return new ResponseEntity<>(dto, HttpStatus.CREATED);
    }
    @PostMapping("/api/users/login")
    public ResponseEntity<LoginResponseDto> login(@RequestBody LoginDto requestBody){
        LoginResponseDto dto = userService.login(requestBody);
        return new ResponseEntity<>(dto, HttpStatus.ACCEPTED);
    }
}

