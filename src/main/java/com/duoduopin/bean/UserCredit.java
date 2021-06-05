package com.duoduopin.bean;

import lombok.Data;

@Data
public class UserCredit {
    private long UserId;
    private int low_weight_point;
    private int common_weight_point;
    private int high_weight_point;
    private int total_number;
    private double average_point;
    public UserCredit(long UserId,int low_weight_point,int common_weight_point,int high_weight_point)
    {
        this.UserId = UserId;
        this.low_weight_point = low_weight_point;
        this.common_weight_point = common_weight_point;
        this.high_weight_point = high_weight_point;
        this.total_number = 1;
        this.average_point = (low_weight_point+common_weight_point+high_weight_point);
    }
}
