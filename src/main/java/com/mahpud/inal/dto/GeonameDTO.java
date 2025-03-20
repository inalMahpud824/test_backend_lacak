package com.mahpud.inal.dto;

import com.mahpud.inal.model.entity.GeoName;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class GeonameDTO {
  private String name;
  private Double latitude;
  private Double longitude;
  private Double score;

  public static GeonameDTO fromEntity(GeoName entity, Double score) {
    String fullName = entity.getName();
    if (entity.getCountryCode() != null && entity.getAdmin1() != null) {
      fullName += ", " + entity.getAdmin1() + ", " + entity.getCountryCode();
    }
    return new GeonameDTO(fullName, entity.getLatitude(), entity.getLongitude(), score);
  }
}
