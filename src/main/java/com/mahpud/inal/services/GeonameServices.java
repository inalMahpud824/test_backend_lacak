package com.mahpud.inal.services;

import java.util.List;
import java.util.stream.Collectors;
import org.apache.commons.text.similarity.JaroWinklerSimilarity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.mahpud.inal.dto.GeonameDTO;
import com.mahpud.inal.dto.GeonameResponse;
import com.mahpud.inal.model.entity.GeoName;
import com.mahpud.inal.model.repositories.GeonameRepository;

@Service
public class GeonameServices {
  @Autowired
  private GeonameRepository geonameRepository;

  private final JaroWinklerSimilarity similarity = new JaroWinklerSimilarity();

  public GeonameResponse getSuggestion(String q, Double latitude, Double longitude) {
    List<GeoName> response = geonameRepository.findByNameStartingWithIgnoreCase(q);

    if (response.isEmpty()) {
      return new GeonameResponse(List.of());
    }

    List<GeonameDTO> suggestions = response.stream().map(g -> {
      double nameScore = similarity.apply(q, g.getName());

      if (latitude == null || longitude == null) {
        nameScore = Math.round(nameScore * 10) / 10.0;
        return new GeonameDTO(g.getName(), g.getLatitude(), g.getLongitude(), nameScore);
      }

      double locationScore = 1 - ((Math.abs(g.getLatitude() - latitude) + Math.abs(g.getLongitude() - longitude)) / 10);
      locationScore = Math.max(0, locationScore);

      double finalScore = (0.7 * nameScore) + (0.3 * locationScore);
      finalScore = Math.round(finalScore * 10) / 10.0; // Satu angka di belakang koma

      return new GeonameDTO(g.getName(), g.getLatitude(), g.getLongitude(), finalScore);
    }).sorted((a, b) -> Double.compare(b.getScore(), a.getScore())) // Sort dari terbesar ke terkecil
        .collect(Collectors.toList());

    return new GeonameResponse(suggestions);
  }
}
