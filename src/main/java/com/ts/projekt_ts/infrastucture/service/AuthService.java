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
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthService {
    private final AuthRepository authRepository;
    private final UserRepository userRepository;
    private final JwtService jwtService;
    private final PasswordEncoder passwordEncoder;
    @Autowired
    public AuthService(AuthRepository authRepository, UserRepository userRepository, JwtService jwtService, PasswordEncoder passwordEncoder) {
        this.authRepository = authRepository;
        this.userRepository = userRepository;
        this.jwtService = jwtService;
        this.passwordEncoder = passwordEncoder;

    }

    public RegisterResponseDto register(RegisterDto dto){
        UserEntity userEntity = new UserEntity();
        userEntity.setEmail(dto.getEmail());
        userRepository.save(userEntity);

        AuthEntity authEntity = new AuthEntity();
        authEntity.setPassword(passwordEncoder.encode(dto.getPassword()));
        authEntity.setRole(dto.getRole());
        authEntity.setUsername(dto.getUsername());
        authEntity.setUser(userEntity);
        authRepository.save(authEntity);

        return new RegisterResponseDto(userEntity.getId(), authEntity.getUsername(), authEntity.getRole());
    }

    public LoginResponseDto login(LoginDto dto){
        AuthEntity authEntity = authRepository.findByUsername(dto.getUsername()).orElseThrow(RuntimeException::new);
        if(!passwordEncoder.matches(authEntity.getPassword(), dto.getPassword())){
            throw new RuntimeException();
        }

        String token = jwtService.generateToken(authEntity);

        return new LoginResponseDto(token);
    }

}
