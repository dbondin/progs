package com.dbondin.simblog;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.util.TestPropertyValues;
import org.springframework.context.ApplicationContextInitializer;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.testcontainers.containers.PostgreSQLContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;

@SpringBootTest
@Testcontainers
@ContextConfiguration(initializers = SimblogApplicationTests.TestContextInitializer.class)
public class SimblogApplicationTests {

  public static class TestContextInitializer implements ApplicationContextInitializer<ConfigurableApplicationContext> {
    @Override
    public void initialize(ConfigurableApplicationContext applicationContext) {
      TestPropertyValues
          .of("spring.datasource.url=" + postgresqlContainer.getJdbcUrl(),
              "spring.datasource.username=" + postgresqlContainer.getUsername(),
              "spring.datasource.password=" + postgresqlContainer.getPassword())
          .applyTo(applicationContext.getEnvironment());
    }
  }

  public static class TestPostgreSQLContainer extends PostgreSQLContainer<TestPostgreSQLContainer> {
    public TestPostgreSQLContainer(String dockerImageName) {
      super(dockerImageName);
    }
  };

  @Container
  public static TestPostgreSQLContainer postgresqlContainer = new TestPostgreSQLContainer("postgres:12.2")
      .withDatabaseName("foo").withUsername("foo").withPassword("secret");

  @Test
  void contextLoads() {
  }

}
