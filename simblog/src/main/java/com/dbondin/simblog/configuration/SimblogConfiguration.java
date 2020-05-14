package com.dbondin.simblog.configuration;

import javax.validation.constraints.NotNull;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.validation.annotation.Validated;

import lombok.Data;

@Configuration
@ConfigurationProperties(prefix = "simblog")
@Data
public class SimblogConfiguration {

  @Data
  public static final class Jwt {
      private String secret;
      private long tokenTtl;
  }
  
  private Jwt jwt;
  private String defaultUsername;
  private String defaultPassword;
}
