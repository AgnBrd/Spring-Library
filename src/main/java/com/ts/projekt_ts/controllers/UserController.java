package com.ts.projekt_ts.controllers;

import com.ts.projekt_ts.controllers.dto.CreateResponseBookDto;
import com.ts.projekt_ts.controllers.dto.CreateResponseUserDto;
import com.ts.projekt_ts.controllers.dto.GetUserDto;
import com.ts.projekt_ts.controllers.dto.CreateUserDto;
import com.ts.projekt_ts.infrastucture.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public List<GetUserDto> getAllUsers() {
        return userService.getAll();
    }

    @GetMapping("/{id}")
    public GetUserDto getOne(@PathVariable long id) {
        return userService.getOne(id);
    }

    @PostMapping
    public ResponseEntity<CreateResponseUserDto> create(@RequestBody CreateUserDto user) {
        var newUser = userService.create(user);
        return new ResponseEntity<>(newUser, HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable long id) {
        userService.delete(id);
        return ResponseEntity.noContent().build();
    }
}

