package com.duoduopin.config;

import java.util.Arrays;

/**
 * @author z217
 * @description 实用类
 * @date 2021/01/06
 */
public abstract class DuoDuoPinUtils {
  //  当前登录用户id的字段名
  public static final String CURRENT_USER_ID = "CURRENT_USER_ID";
  //  token有效期
  public static final int TOKEN_EXPIRES_HOUR = 72;
  //  存放Authorization的header字段
  public static final String AUTHORIZATION = "token";
  //  管理员账户id
  public static final Long[] ADMIN_ID = new Long[1];
  
  static {
    ADMIN_ID[0] = 1L;
  }
  
  public static boolean checkIfAdmin(Long id) {
    return Arrays.binarySearch(ADMIN_ID, id) >= 0;
  }
}
