package com.duoduopin.bean;

import com.duoduopin.config.BillType;
import lombok.*;

import java.math.BigDecimal;
import java.sql.Timestamp;

/**
 * 拼单实体类
 *
 * @author z217
 * @date 2020/08/07
 */
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class ShareBill {
  protected long billId;
  protected long userId;
  protected String nickname;
  protected String title;
  protected BillType type;
  protected String description;
  protected String address;
  protected Timestamp time;
  protected int curPeople;
  protected int maxPeople;
  protected BigDecimal price;
  protected double longitude;
  protected double latitude;
  protected String geohash;

  public ShareBill(ShareBill shareBill) {
    this.billId = shareBill.billId;
    this.userId = shareBill.userId;
    this.nickname = shareBill.nickname;
    this.title = shareBill.title;
    this.type = shareBill.type;
    this.description = shareBill.description;
    this.address = shareBill.address;
    this.time = shareBill.time;
    this.curPeople = shareBill.curPeople;
    this.maxPeople = shareBill.maxPeople;
    this.price = shareBill.price;
    this.longitude = shareBill.longitude;
    this.latitude = shareBill.latitude;
    this.geohash = shareBill.geohash;
  }
  
  public ShareBill(
    long userId,
    String title,
    BillType type,
    String description,
    String address,
    Timestamp time,
    int curPeople,
    int maxPeople,
    BigDecimal price,
    double longitude,
    double latitude,
    String geohash) {
    this.userId = userId;
    this.title = title;
    this.type = type;
    this.description = description;
    this.address = address;
    this.time = time;
    this.price = price;
    this.curPeople = curPeople;
    this.maxPeople = maxPeople;
    this.longitude = longitude;
    this.latitude = latitude;
    this.geohash = geohash;
  }
}
