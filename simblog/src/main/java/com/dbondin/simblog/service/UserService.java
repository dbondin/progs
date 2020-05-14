package com.dbondin.simblog.service;

import java.util.Optional;

import com.dbondin.simblog.entity.User;

public interface UserService {
  long count();
  Optional<User> findById(Long id);
  Optional<User> findByUsername(String username);
  User save(final User user);
}
