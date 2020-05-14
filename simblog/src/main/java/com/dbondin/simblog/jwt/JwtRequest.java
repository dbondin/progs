package com.dbondin.simblog.jwt;

import java.io.Serializable;

import lombok.Data;

@Data
public class JwtRequest implements Serializable {

  private static final long serialVersionUID = -6514549245817257779L;
  
  private String username;
  private String password;

}
