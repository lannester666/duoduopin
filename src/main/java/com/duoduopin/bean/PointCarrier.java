package com.duoduopin.bean;

import lombok.Data;

@Data
public class PointCarrier {
    private Double point;
    public PointCarrier(double point)
    {
        this.point = point;
    }

    public static void main(String[] args) {
        double d=1;
        String s=String.format("%.1f",d);
        System.out.println(s);
    }
}

