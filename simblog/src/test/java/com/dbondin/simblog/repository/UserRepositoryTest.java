package com.dbondin.simblog.repository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.testcontainers.junit.jupiter.Testcontainers;

import com.dbondin.simblog.AbstractSimblogTest;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@SpringBootTest
@Testcontainers
@ContextConfiguration(initializers = AbstractSimblogTest.TestContextInitializer.class)
public class UserRepositoryTest extends AbstractSimblogTest {
  
  @Autowired
  private UserRepository userRepository;
  
  @Test
  public void test() {
    log.info("count={}", userRepository.count());
  }
}
