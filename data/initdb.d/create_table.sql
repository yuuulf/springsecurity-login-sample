DROP TABLE IF EXISTS users;
CREATE TABLE users(
  user_id INT NOT NULL AUTO_INCREMENT COMMENT 'ユーザID',
  mail_address VARCHAR(255) NOT NULL COMMENT 'メールアドレス',
  password VARCHAR(255) NOT NULL COMMENT 'パスワード',
  user_name VARCHAR(100) NOT NULL COMMENT 'ユーザ名',
  valid_flag TINYINT NOT NULL DEFAULT 1 COMMENT '有効フラグ',
  update_user INT DEFAULT NULL COMMENT '更新者',
  update_date DATETIME DEFAULT NULL COMMENT '更新日時',
  PRIMARY KEY (user_id)
) COMMENT='ユーザ';

