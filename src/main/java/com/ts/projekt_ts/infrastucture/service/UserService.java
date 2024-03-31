package com.ts.projekt_ts.infrastucture.service;

import com.ts.projekt_ts.controllers.dto.CreateResponseUserDto;
import com.ts.projekt_ts.controllers.dto.GetUserDto;
import com.ts.projekt_ts.controllers.dto.CreateUserDto;
import com.ts.projekt_ts.infrastucture.entity.UserEntity;
import com.ts.projekt_ts.infrastucture.entity.UserRole;
import com.ts.projekt_ts.infrastucture.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserService {
    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<GetUserDto> getAll() {
        var users = userRepository.findAll();
        return users.stream()
                .map(user -> new GetUserDto(user.getId(), user.getLogin(), user.getName(), user.getRole(), user.getEmail()))
                .collect(Collectors.toList());
    }

    public GetUserDto getOne(long id) {
        var user = userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found"));
        return new GetUserDto(user.getId(), user.getLogin(), user.getName(), user.getRole(), user.getEmail());
    }

    public CreateResponseUserDto create(CreateUserDto user) {
        var userEntity = new UserEntity();
        userEntity.setLogin(user.getLogin());
        userEntity.setPassword(user.getPassword());
        userEntity.setName(user.getName());
        userEntity.setRole(UserRole.valueOf(user.getRole()));
        userEntity.setEmail(user.getEmail());
        var newUser = userRepository.save(userEntity);
        return new CreateResponseUserDto(newUser.getId(), newUser.getLogin(), newUser.getName(), newUser.getRole(), newUser.getEmail());
    }

    public void delete(long id) {
        if (!userRepository.existsById(id)) {
            throw new RuntimeException("User not found");
        }
        userRepository.deleteById(id);
    }
}
