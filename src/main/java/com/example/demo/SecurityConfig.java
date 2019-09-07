package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import com.example.demo.security.AccountUserDetailsService;


@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {

  @Autowired
  AccountUserDetailsService userDetailsService;

  @Override
  public void configure(WebSecurity web) {
    web.ignoring().antMatchers("/images/**", "/css/**", "/js/**"); // 静的ファイルには認証をかけない
  }

  @Override
  protected void configure(HttpSecurity http) throws Exception {
    // 認可の設定
    http.authorizeRequests().antMatchers("/login").permitAll() // 許可
        .anyRequest().authenticated() // 以外は全て認証無しの場合アクセス不許可
        // ログイン設定
        .and().formLogin().loginProcessingUrl("/login") // ログイン処理をするURL
        .loginPage("/login") // ログイン画面URL
        .failureUrl("/login?error") // 認証失敗時のURL
        .defaultSuccessUrl("/home") // 認証成功時のURL
        .usernameParameter("email") // ユーザのパラメータ名
        .passwordParameter("password") // パスワードのパラメータ名
        // ログアウト設定
        .and().logout().logoutUrl("/logout") // ログアウトURL(指定しなければ"/logout")
        .logoutSuccessUrl("/login"); // ログアウト成功時のURL

  }

  @Bean
  public PasswordEncoder passwordEncoder() {
    return new BCryptPasswordEncoder();
  }

  @Autowired
  void configureAuthenticationManager(AuthenticationManagerBuilder auth) throws Exception {
    auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());
  }

}
