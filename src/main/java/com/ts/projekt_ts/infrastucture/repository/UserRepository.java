package com.ts.projekt_ts.infrastucture.repository;

import com.ts.projekt_ts.infrastucture.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, Long> {
}