package com.dbondin.simblog.jwt;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.dbondin.simblog.service.UserService;

@Service
public class JwtUserDetailsService implements UserDetailsService {

  @Autowired
  private UserService userService;
  
  @Override
  public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
    final com.dbondin.simblog.entity.User simblogUser = userService.findByUsername(username)
        .orElseThrow(() -> new UsernameNotFoundException("User not found with username: " + username));

    return new User(simblogUser.getUsername(), simblogUser.getPassword(), new ArrayList<>());
  }
}