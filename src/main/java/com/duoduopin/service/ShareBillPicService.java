package com.duoduopin.service;

import com.duoduopin.bean.ShareBillPic;
import com.duoduopin.dao.PicMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class ShareBillPicService {
    @Autowired
    private PicMapper picMapper;
    public void add_share_bill_pic(long share_bill_id,String url)
    {
        picMapper.add_share_bill(new ShareBillPic(share_bill_id,url));
    }
    public void update_share_bill_pic(long share_bill_id,String url)
    {
        picMapper.update_share_bill(share_bill_id, url);
    }
    public String get_share_bill_pic(long share_bill_id)
    {
        return picMapper.search_share_bill(share_bill_id);
    }
}
