package com.example.demo.model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Data;

/**
 * ユーザ
 */
@Entity
@Data
@Table(name = "users")
public class User implements Serializable {
  private static final long serialVersionUID = 1L;

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "user_id")
  private Integer userId;

  @Column(name = "mail_address")
  private String mailAddress;

  @Column(name = "password")
  private String password;

  @Column(name = "user_name")
  private String userName;

  @Column(name = "valid_flag")
  private Integer validFlag;

  @Column(name = "update_date")
  private Date updateDate;

  @Column(name = "update_user")
  private Integer updateUser;

}
