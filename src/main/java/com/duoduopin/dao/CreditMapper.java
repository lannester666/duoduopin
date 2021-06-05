package com.duoduopin.dao;
import com.duoduopin.bean.UserCredit;
import org.apache.ibatis.annotations.Param;

public interface CreditMapper {
    int add(UserCredit userCredit);
    UserCredit get_Credit_byId(long UserId);
    int update(UserCredit userCredit);
}
