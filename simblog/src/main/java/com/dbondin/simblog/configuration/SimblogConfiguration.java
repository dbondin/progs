package com.dbondin.simblog.configuration;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

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
  
}
