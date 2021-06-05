package com.duoduopin.bean;

import lombok.Data;

@Data
public class ShareBillPic {
    private long BillId;
    private String url;
    public ShareBillPic(long id, String url)
    {
        this.BillId = id;
        this.url = url;
    }
}
