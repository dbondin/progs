package com.dbondin.simblog.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dbondin.simblog.entity.User;
import com.dbondin.simblog.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {

  @Autowired
  private UserRepository userRepository;
  
  @Override
  @Transactional(readOnly = true)
  public long count() {
    return userRepository.count();
  }
  
  @Override
  @Transactional(readOnly = false)
  public Optional<User> findById(final Long id) {
    return userRepository.findById(id);
  }
  
  @Override
  @Transactional(readOnly = false)
  public User save(final User user) {
    return userRepository.save(user);
  }
  
  @Override
  @Transactional(readOnly = true)
  public Optional<User> findByUsername(final String username) {
    return userRepository.findByUsername(username);
  }
}
