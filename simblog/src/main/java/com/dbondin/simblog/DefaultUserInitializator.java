package com.dbondin.simblog;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import com.dbondin.simblog.configuration.SimblogConfiguration;
import com.dbondin.simblog.entity.User;
import com.dbondin.simblog.service.UserService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class DefaultUserInitializator implements ApplicationListener<ContextRefreshedEvent> {
  
  @Autowired
  private SimblogConfiguration simblogConfiguration;
  
  @Autowired
  private UserService userService;
  
  @Autowired
  private PasswordEncoder passwordEncoder;
  
  @Override
  public void onApplicationEvent(ContextRefreshedEvent event) {
    log.info("Checking if any users exists in database");
    if(userService.count() == 0) {
      log.warn("No users found. Creating default one");
      final User user = new User();
      user.setUsername(simblogConfiguration.getDefaultUsername());
      user.setPassword(passwordEncoder.encode(simblogConfiguration.getDefaultPassword()));
      userService.save(user);
    }
  }

}
