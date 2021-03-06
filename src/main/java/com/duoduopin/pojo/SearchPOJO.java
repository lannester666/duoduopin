package com.duoduopin.pojo;

import ch.hsr.geohash.GeoHash;
import com.duoduopin.bean.ShareBillWithDistance;
import com.duoduopin.config.BillType;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.List;

/**
 * 存储搜索条件
 *
 * @author z217
 * @date 2020/08/12
 */
@Getter
@Setter
@ToString
public class SearchPOJO {
  private BillType type;
  private String description;
  private Timestamp startTime;
  private Timestamp endTime;
  private BigDecimal minPrice;
  private BigDecimal maxPrice;
  private Double longitude;
  private Double latitude;
  private String[] geohashs = new String[9];
  private Distance distance;
  
  /**
   * 可选的距离枚举
   */
  public static enum Distance {
    NONE {
      @Override
      public void setGeohashs(double longitude, double latitude, String[] geohashs) {
      }
      
      @Override
      public void distanceFilter(List<ShareBillWithDistance> shareBills) {
      }
    },
    M500 {
      @Override
      public void setGeohashs(double longitude, double latitude, String[] geohashs) {
        GeoHash geoHash = GeoHash.withCharacterPrecision(latitude, longitude, 6);
        GeoHash[] adjacent = geoHash.getAdjacent();
        geohashs[0] = geoHash.toBase32();
        int i = 1;
        for (GeoHash hash : adjacent) {
          geohashs[i++] = hash.toBase32();
        }
      }

      @Override
      public void distanceFilter(List<ShareBillWithDistance> shareBills) {
        shareBills.removeIf(shareBill -> shareBill.getDistance() > 0.500);
      }
    },
    KM1 {
      @Override
      public void setGeohashs(double longitude, double latitude, String[] geohashs) {
        GeoHash geoHash = GeoHash.withCharacterPrecision(latitude, longitude, 6);
        GeoHash[] adjacent = geoHash.getAdjacent();
        geohashs[0] = geoHash.toBase32();
        int i = 1;
        for (GeoHash hash : adjacent) {
          geohashs[i++] = hash.toBase32();
        }
      }

      @Override
      public void distanceFilter(List<ShareBillWithDistance> shareBills) {
        shareBills.removeIf(shareBill -> shareBill.getDistance() > 1.000);
      }
    },
    KM2 {
      @Override
      public void setGeohashs(double longitude, double latitude, String[] geohashs) {
        GeoHash geoHash = GeoHash.withCharacterPrecision(latitude, longitude, 5);
        GeoHash[] adjacent = geoHash.getAdjacent();
        geohashs[0] = geoHash.toBase32();
        int i = 1;
        for (GeoHash hash : adjacent) {
          geohashs[i++] = hash.toBase32();
        }
      }

      @Override
      public void distanceFilter(List<ShareBillWithDistance> shareBills) {
        shareBills.removeIf(shareBill -> shareBill.getDistance() > 2.000);
      }
    };

    public abstract void setGeohashs(double longitude, double latitude, String[] geohashs);

    public abstract void distanceFilter(List<ShareBillWithDistance> shareBills);
  }
}
