package com.duoduopin.bean;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.sql.Timestamp;

/**
 * 用户数据的domain类
 *
 * @author ScienJus
 * @date 2015/07/31.
 */
@Getter
@Setter
@ToString
public class User {
  private long userId;
  
  private String username;
  
  private String nickname;
  
  private String password;
  
  private Timestamp lastOnline;
  
  public User(String username, String nickname, String password) {
    this.username = username;
    this.nickname = nickname;
    this.password = password;
  }
}
