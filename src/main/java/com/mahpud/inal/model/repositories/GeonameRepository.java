package com.mahpud.inal.model.repositories;

import org.springframework.stereotype.Repository;

import com.mahpud.inal.model.entity.GeoName;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
// import org.springframework.data.jpa.repository.Query;
// import org.springframework.data.repository.query.Param;

@Repository
public interface GeonameRepository extends JpaRepository<GeoName, Long> {
    // 🔹 Mencari berdasarkan nama (prefix)
    List<GeoName> findByNameStartingWithIgnoreCase(String name);

    // @Query(value = """
    // SELECT * FROM mytable
    // WHERE LOWER(name) LIKE LOWER(CONCAT(:name, '%'))
    // ORDER BY
    // ABS(lat - COALESCE(:latitude, lat)) +
    // ABS(`long` - COALESCE(:longitude, `long`)) ASC
    // LIMIT 10
    // """, nativeQuery = true)
    // List<GeoName> findByNameAndClosestLocation(
    // @Param("name") String name,
    // @Param("latitude") Double latitude,
    // @Param("longitude") Double longitude);

}
