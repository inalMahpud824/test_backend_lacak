package com.mahpud.inal.model.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Table(name = "mytable")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class GeoName {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name", length = 1024)
    private String name;

    @Column(name = "ascii", length = 1024)
    private String ascii;

    @Column(name = "alt_name", length = 1024)
    private String altName;

    @Column(name = "lat")
    private Double latitude;

    @Column(name = "long")
    private Double longitude;

    @Column(name = "feat_class", length = 1)
    private String featureClass;

    @Column(name = "feat_code", length = 10)
    private String featureCode;

    @Column(name = "country", length = 2)
    private String countryCode;

    @Column(name = "cc2", length = 60)
    private String alternateCountryCodes;

    @Column(name = "admin1", length = 1024)
    private String admin1;

    @Column(name = "admin2")
    private Long admin2;

    @Column(name = "admin3")
    private Long admin3;

    @Column(name = "admin4", length = 1024)
    private String admin4;

    @Column(name = "population")
    private Long population;

    @Column(name = "elevation")
    private Long elevation;

    @Column(name = "dem")
    private Long dem;

    @Column(name = "tz", length = 1024)
    private String timezone;

    @Column(name = "modified_at")
    private LocalDateTime modifiedAt;
}