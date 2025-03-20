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
}
