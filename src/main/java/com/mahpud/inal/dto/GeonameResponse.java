package com.mahpud.inal.dto;

import java.util.List;

public class GeonameResponse {
  private List<GeonameDTO> suggestions;

  public GeonameResponse(List<GeonameDTO> suggestions) {
        this.suggestions = suggestions;
    }
    
  public List<GeonameDTO> getSuggestions() {
    return suggestions;
  }
}
