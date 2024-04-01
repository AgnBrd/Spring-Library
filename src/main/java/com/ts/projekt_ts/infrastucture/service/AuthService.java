package com.ts.projekt_ts.infrastucture.service;

import com.ts.projekt_ts.controllers.dto.LoginDto;
import com.ts.projekt_ts.controllers.dto.LoginResponseDto;
import com.ts.projekt_ts.controllers.dto.RegisterDto;
import com.ts.projekt_ts.controllers.dto.RegisterResponseDto;
import com.ts.projekt_ts.infrastucture.entity.AuthEntity;
import com.ts.projekt_ts.infrastucture.entity.UserEntity;
import com.ts.projekt_ts.infrastucture.repository.AuthRepository;
import com.ts.projekt_ts.infrastucture.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthService {
    private final AuthRepository authRepository;
    private final UserRepository userRepository;
    private final JwtService jwtService;
    @Autowired
    public AuthService(AuthRepository authRepository, UserRepository userRepository, JwtService jwtService) {
        this.authRepository = authRepository;
        this.userRepository = userRepository;
        this.jwtService = jwtService;
    }

    public RegisterResponseDto register(RegisterDto dto){
        UserEntity userEntity = new UserEntity();
        userEntity.setEmail(dto.getEmail());
        UserEntity createdUser = userRepository.save(userEntity);

        AuthEntity authEntity = new AuthEntity();
        authEntity.setPassword(dto.getPassword());
        authEntity.setRole(dto.getRole());
        authEntity.setUsername(dto.getUsername());
        authEntity.setUser(createdUser);
        AuthEntity createdAuth = authRepository.save(authEntity);

        return new RegisterResponseDto(createdAuth.getUsername(), createdAuth.getRole());
    }

    public LoginResponseDto login(LoginDto dto){
        AuthEntity authEntity = authRepository.findByUsername(dto.getUsername()).orElseThrow(()->new RuntimeException());
        if(!authEntity.getPassword().equals(dto.getPassword())){
            throw new RuntimeException();
        }
        String token = jwtService.generateToken(authEntity);
        return new LoginResponseDto(token);
    }

}
