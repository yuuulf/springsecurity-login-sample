package com.example.demo.controller;

import java.security.Principal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import com.example.demo.model.User;
import com.example.demo.service.UserService;

/**
 * 画面表示
 */
@Controller
public class MenuController {

  @Autowired
  private UserService userService;

  @GetMapping("/home")
  public String home(Model model, Principal principal) {
    User user = userService.getUserByMail(principal.getName());
    model.addAttribute("userName", user != null ? user.getUserName() : null);
    return "home";
  }

}
