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
    @PreAuthorize("hasRole('EMPLOYEE') || hasRole('ADMIN')")
    public List<GetUserDto> getAllUsers() {
        return userService.getAll();
    }

    @GetMapping("/api/users/{id}")
    @PreAuthorize("hasRole('EMPLOYEE') || hasRole('ADMIN')")
    public GetUserDto getOne(@PathVariable long id) {
        return userService.getOne(id);
}

    @PatchMapping("/api/users/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<UpdateUserResponseDto> update(@PathVariable long id, @Validated @RequestBody UpdateUserDto requestBody){
        UpdateUserResponseDto dto = userService.update(id, requestBody);
        return new ResponseEntity<>(dto, HttpStatus.OK);
    }


    @DeleteMapping("/api/users/{id}")
    @PreAuthorize("hasRole('EMPLOYEE') || hasRole('ADMIN')")
    public ResponseEntity<Void> delete(@PathVariable long id) {
        userService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @PostMapping("/api/users/create")
    @PreAuthorize("hasRole('EMPLOYEE') || hasRole('ADMIN')")
    public ResponseEntity<CreateUserResponseDto> create(@Validated @RequestBody CreateUserDto requestBody){
        CreateUserResponseDto dto = userService.create(requestBody);
        return new ResponseEntity<>(dto, HttpStatus.CREATED);
    }

    @PatchMapping("/api/users/register/{email}")
    public ResponseEntity<RegisterResponseDto> register(@PathVariable String email, @Validated @RequestBody RegisterDto requestBody){
        RegisterResponseDto dto = userService.register(email, requestBody);
        return new ResponseEntity<>(dto, HttpStatus.OK);
    }
    @PostMapping("/api/users/login")
    public ResponseEntity<LoginResponseDto> login(@Validated @RequestBody LoginDto requestBody){
        LoginResponseDto dto = userService.login(requestBody);
        return new ResponseEntity<>(dto, HttpStatus.ACCEPTED);
    }
}

