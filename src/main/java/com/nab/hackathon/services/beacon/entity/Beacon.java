package com.nab.hackathon.services.beacon.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Beacon {
  @Id
  private String beaconId;

  private String name;
  private Long merchantId;
  private String type;

  public Beacon() {
  }

  public Beacon(String name, Long merchantId, String type) {
    this.name = name;
    this.merchantId = merchantId;
    this.type = type;
  }

  public String getBeaconId() {
    return beaconId;
  }

  public void setBeaconId(String beaconId) {
    this.beaconId = beaconId;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Long getMerchantId() {
    return merchantId;
  }

  public void setMerchantId(Long merchantId) {
    this.merchantId = merchantId;
  }

  public String getType() {
    return type;
  }

  public void setType(String type) {
    this.type = type;
  }

  @Override
  public String toString() {
    return "Beacon{" +
        "beaconId=" + beaconId +
        ", name='" + name + '\'' +
        ", merchantId=" + merchantId +
        ", type='" + type + '\'' +
        '}';
  }
}
