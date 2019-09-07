package com.example.demo.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import com.example.demo.model.User;
import com.example.demo.service.UserService;

@Component
public class AccountUserDetailsService implements UserDetailsService {

  @Autowired
  private UserService userService;

  @Override
  public UserDetails loadUserByUsername(String mailAdress) throws UsernameNotFoundException {

    User user = userService.getUserByMail(mailAdress);

    if (user == null) {
      throw new UsernameNotFoundException(mailAdress);
    }

    return new AccountUserDetails(user);
  }

}
