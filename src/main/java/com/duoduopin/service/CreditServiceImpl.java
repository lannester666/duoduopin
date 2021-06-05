package com.duoduopin.service;

import com.duoduopin.bean.UserCredit;
import com.duoduopin.dao.CreditMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
@Slf4j
public class CreditServiceImpl implements CreditService{
    @Autowired
    CreditMapper creditMapper;

    @Override
    public boolean isExist(long UserId) {
        return creditMapper.get_Credit_byId(UserId) != null;
    }

    @Override
    public String update(long current_user_id,long UserId, int point) {
        if(!isExist(UserId)) {
            log.warn("无法查询到此id的用户信息");
            if(creditMapper.get_Credit_byId(current_user_id)!=null) {
                UserCredit current_user = creditMapper.get_Credit_byId(current_user_id);
                double current_user_point = current_user.getAverage_point();
                if (current_user_point < 70) {
                    creditMapper.add(new UserCredit(UserId, point, 0, 0));
                } else if (current_user_point >= 70 && current_user_point <= 90) {
                    creditMapper.add(new UserCredit(UserId, 0, point, 0));
                } else {
                    creditMapper.add(new UserCredit(UserId, 0, 0, point));
                }
            }
            else {
                creditMapper.add(new UserCredit(UserId, 0, point, 0));
            }
            return String.format("%.1f",(double)point);
        }
        else
        {
            UserCredit userCredit = creditMapper.get_Credit_byId(UserId);
            if(creditMapper.get_Credit_byId(current_user_id)!=null) {
                UserCredit current_user = creditMapper.get_Credit_byId(current_user_id);
                double current_user_point = current_user.getAverage_point();
                if(current_user_point<70) {
                    userCredit.setLow_weight_point(userCredit.getLow_weight_point() + point);
                    userCredit.setTotal_number(userCredit.getTotal_number() + 1);
                    userCredit.setAverage_point(average_point(userCredit));
                    creditMapper.update(userCredit);
                }
                else if(current_user_point>=70&&current_user_point<=90)
                {
                    userCredit.setCommon_weight_point(userCredit.getCommon_weight_point()+point);
                    userCredit.setTotal_number(userCredit.getTotal_number() + 1);
                    userCredit.setAverage_point(average_point(userCredit));
                    creditMapper.update(userCredit);
                }
                else{
                    userCredit.setHigh_weight_point(userCredit.getHigh_weight_point()+point);
                    userCredit.setTotal_number(userCredit.getTotal_number() + 1);
                    userCredit.setAverage_point(average_point(userCredit));
                    creditMapper.update(userCredit);
                }
            }
            else
            {
                userCredit.setCommon_weight_point(userCredit.getCommon_weight_point()+point);
                userCredit.setTotal_number(userCredit.getTotal_number() + 1);
                userCredit.setAverage_point(average_point(userCredit));
                creditMapper.update(userCredit);
            }

        }
        return String.format("%.1f", creditMapper.get_Credit_byId(UserId).getAverage_point());
    }
    public double average_point(UserCredit userCredit)
    {
        int high_point = userCredit.getHigh_weight_point();
        int common_point = userCredit.getCommon_weight_point();
        int low_point = userCredit.getLow_weight_point();
        int total_user = userCredit.getTotal_number();
        if(high_point>0&&common_point>0&&low_point>0)
        {
            return (high_point*1.2+common_point+low_point*0.8)/(total_user*(1.2+1+0.8));
        }
        else if(high_point==0)
        {
            if (common_point>0&&low_point>0)
                return (common_point+low_point*0.8)/(total_user*(1+0.8));
            else if(common_point==0)
                return (double)(low_point/total_user);
            else return (double)common_point/total_user;
        }
        else if(common_point==0)
        {
            if (high_point>0&&low_point>0)
                return (high_point*1.2+low_point*0.8)/(total_user*(1.2+0.8));
            else if(low_point==0)
                return (double)low_point/total_user;
        }
        else if(low_point==0)
        {
            if (high_point>0&&common_point>0)
                return (high_point*1.2+common_point)/(total_user*(1.2+1));
            else return  (double)high_point/total_user;
        }
        return 0;
    }

}
