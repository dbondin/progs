package com.dbondin.simblog.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "simblog_user")
@SequenceGenerator(sequenceName = "simblog_user_id_seq", name = AbstractEntity.GENERATOR_NAME, allocationSize = 1)
@Data
public class User extends AbstractEntity {

  @Column(name = "username", length = 255, nullable = false, unique = true)
  private String username;
  
  @Column(name = "password", length = 255, nullable = false, unique = false)
  private String password;
}
