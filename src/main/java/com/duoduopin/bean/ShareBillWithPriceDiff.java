package com.duoduopin.bean;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@NoArgsConstructor
public class ShareBillWithPriceDiff extends ShareBill{
    private double price_diff;

    public ShareBillWithPriceDiff(ShareBill shareBill, BigDecimal price) {
        super(shareBill);
        this.price_diff = Math.abs(shareBill.getPrice().doubleValue()-price.doubleValue());
    }
}
