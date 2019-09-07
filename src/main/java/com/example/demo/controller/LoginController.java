package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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

  @GetMapping("/home")
  public String loginsuccess(@ModelAttribute LoginForm loginForm, Model model) {
    model.addAttribute("message", "ログイン成功!!");
    return "home";
  }

}
