package com.example.demo.form;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import lombok.Data;

/**
 * ログインフォーム
 */
@Data
public class LoginForm {
  @NotEmpty
  @Email
  private String email;

  @NotEmpty
  private String password;
}
