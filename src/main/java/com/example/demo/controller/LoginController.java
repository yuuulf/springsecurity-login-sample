package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import com.example.demo.form.LoginForm;

/**
 * ログイン
 */
@Controller
public class LoginController {

  @GetMapping("/login")
  public String show(@ModelAttribute LoginForm form) {
    return "login";
  }

}
