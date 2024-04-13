package com.ts.projekt_ts.infrastucture.repository;

import com.ts.projekt_ts.commonTypes.UserRole;
import com.ts.projekt_ts.infrastucture.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, Long> {
    Optional<UserEntity> findByUsername(String username);

    Optional<UserEntity> findByEmail(String email);

    Optional<UserEntity> findByRole(UserRole role);
}