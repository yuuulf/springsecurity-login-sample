package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo.model.User;
import com.example.demo.repository.UserRepository;

@Service
public class UserService {
  @Autowired
  UserRepository userRepository;

  /**
   * ユーザIDからユーザを取得
   *
   * @param userId
   * @return ユーザ
   */
  public User getUser(Integer userId) {
    return userRepository.findById(userId).orElse(null);
  }

  /**
   * ールアドレスからユーザを取得
   *
   * @param mailAddress メールアドレス
   * @return ユーザ
   */
  public User getUserByMail(String mailAddress) {
    return userRepository.findByMailAddress(mailAddress);
  }
}
