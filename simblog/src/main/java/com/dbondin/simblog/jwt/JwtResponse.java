package com.dbondin.simblog.jwt;

import java.io.Serializable;

import lombok.Data;

@Data
public class JwtResponse implements Serializable {

  private static final long serialVersionUID = -3993237474168205143L;
  
  private final String jwttoken;
  
}
