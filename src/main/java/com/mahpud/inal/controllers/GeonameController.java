package com.mahpud.inal.controllers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.mahpud.inal.dto.GeonameResponse;
import com.mahpud.inal.services.GeonameServices;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@RestController
@RequestMapping("/suggestions")
public class GeonameController {

  @Autowired
  private GeonameServices geonameServices;

  @GetMapping()
  public GeonameResponse getSuggestion(
      @RequestParam String q,
      @RequestParam(required = false) Double latitude,
      @RequestParam(required = false) Double longitude) {
    return geonameServices.getSuggestion(q, latitude, longitude);
  }
}
