package com.duoduopin.service;

public interface CreditService {
    public boolean isExist(long UserId);
    public String update(long current_user_id,long UserId,int point);
}
