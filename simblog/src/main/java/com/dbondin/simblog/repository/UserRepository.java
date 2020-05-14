package com.dbondin.simblog.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dbondin.simblog.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {
  Optional<User> findByUsername(String username);
}
