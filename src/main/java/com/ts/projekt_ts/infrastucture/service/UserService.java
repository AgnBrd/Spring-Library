package com.ts.projekt_ts.infrastucture.service;

import com.ts.projekt_ts.controllers.dto.*;

import com.ts.projekt_ts.exception.EmailAlreadyExistsException;
import com.ts.projekt_ts.exception.UserAlreadyExistsException;
import com.ts.projekt_ts.infrastucture.entity.UserEntity;
import com.ts.projekt_ts.infrastucture.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;

    @Autowired
    public UserService(UserRepository userRepository, PasswordEncoder passwordEncoder, JwtService jwtService) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.jwtService = jwtService;
    }

    public List<GetUserDto> getAll() {
        var users = userRepository.findAll();
        return users.stream()
                .map(user -> new GetUserDto(user.getId(), user.getUsername(), user.getName(), user.getRole(), user.getEmail()))
                .collect(Collectors.toList());
    }

    public GetUserDto getOne(long id) {
        var user = userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found"));
        return new GetUserDto(user.getId(), user.getUsername(), user.getName(), user.getRole(), user.getEmail());
    }


    public void delete(long id) {
        if (userRepository.existsById(id)) {
            userRepository.deleteById(id);
        } else {
            throw new RuntimeException("User not found");
        }
    }

    public UpdateUserResponseDto update(long id, UpdateUserDto dto) {
        var user = userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found"));
        user.setUsername(dto.getUsername());
        user.setPassword(dto.getPassword());
        user.setEmail(dto.getEmail());
        user.setRole(dto.getRole());
        user.setName(dto.getName());
        userRepository.save(user);

        return new UpdateUserResponseDto(user.getId(), user.getUsername(), user.getRole(), user.getEmail());
    }

    public CreateUserResponseDto create(CreateUserDto dto) {
        Optional<UserEntity> existingEmail = userRepository.findByEmail(dto.getEmail());
        if(existingEmail.isPresent()){
            throw EmailAlreadyExistsException.create(dto.getEmail());
        }

        var userEntity = new UserEntity();
        userEntity.setName(dto.getName());
        userEntity.setRole(dto.getRole());
        userEntity.setEmail(dto.getEmail());
        userRepository.save(userEntity);

        return new CreateUserResponseDto(userEntity.getId(), userEntity.getName(), userEntity.getRole(), userEntity.getEmail());
    }

    public RegisterResponseDto register(String email, RegisterDto dto) {
        var user = userRepository.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("User with this email not found"));

        Optional<UserEntity> existingUsername = userRepository.findByUsername(dto.getUsername());
        if(existingUsername.isPresent()){
            throw UserAlreadyExistsException.create(dto.getUsername());
        }

        user.setUsername(dto.getUsername());
        user.setPassword(passwordEncoder.encode(dto.getPassword()));
        userRepository.save(user);

        return new RegisterResponseDto(user.getUsername());
    }

    public LoginResponseDto login(LoginDto dto) {
        Optional<UserEntity> notExistingUsername = userRepository.findByUsername(dto.getUsername());
        if(!notExistingUsername.isPresent()){
            throw UserAlreadyExistsException.create(dto.getUsername());
        }

        UserEntity userEntity = userRepository.findByUsername(dto.getUsername()).orElseThrow(() -> new RuntimeException("user not found"));
        if (passwordEncoder.matches(dto.getPassword(), userEntity.getPassword())) {
            String token = jwtService.generateToken(userEntity);

            return new LoginResponseDto(token);
        } else {
            throw new RuntimeException("incorect password");

        }
    }
}
