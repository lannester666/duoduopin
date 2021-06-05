package com.duoduopin.dao;
import com.duoduopin.pojo.picPOJO;
import org.apache.ibatis.annotations.Param;
import com.duoduopin.bean.ShareBillPic;
public interface PicMapper {
    int add (picPOJO pic);
    int update(@Param("UserId") long UserId,@Param("url") String url);
    String search (@Param("UserId") long UserId);
    int add_share_bill(ShareBillPic pic);
    int update_share_bill(@Param("ShareBillId") long ShareBillId, @Param("url") String url);
    String search_share_bill(long ShareBillId);
}
