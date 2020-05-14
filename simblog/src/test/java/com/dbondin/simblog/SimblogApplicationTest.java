package com.dbondin.simblog;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.testcontainers.junit.jupiter.Testcontainers;

@SpringBootTest
@Testcontainers
@ContextConfiguration(initializers = AbstractSimblogTest.TestContextInitializer.class)
public class SimblogApplicationTest extends AbstractSimblogTest {
  
  @Test
  void contextLoads() {
  }

}
