package com.example.demo.security;

import java.util.Collection;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import com.example.demo.model.User;

public class AccountUserDetails implements UserDetails {

  private User user;

  public AccountUserDetails(User user) {
    this.user = user;
  }

  @Override
  public Collection<? extends GrantedAuthority> getAuthorities() {
    return null;
  }

  @Override
  public String getPassword() {
    return user.getPassword();
  }

  @Override
  public String getUsername() {
    return user.getMailAddress();
  }

  @Override
  public boolean isAccountNonExpired() {
    // 期限は存在しないためtrue
    return true;
  }

  @Override
  public boolean isAccountNonLocked() {
    // アカウントロックは存在しないためtrue
    return true;
  }

  @Override
  public boolean isCredentialsNonExpired() {
    // 資格情報は存在しないためtrue
    return true;
  }

  @Override
  public boolean isEnabled() {
    return user.getValidFlag() == 1;
  }

}
