package com.example.educonnect_platform.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.educonnect_platform.entity.User;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByFireBaseUid(String fireBaseUid);
    Optional<User> findByUserName(String userName);
}
