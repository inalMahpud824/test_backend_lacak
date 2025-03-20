package com.mahpud.inal;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.mahpud.inal.dto.GeonameDTO;
import com.mahpud.inal.dto.GeonameResponse;
import com.mahpud.inal.model.entity.GeoName;
import com.mahpud.inal.model.repositories.GeonameRepository;
import com.mahpud.inal.services.GeonameServices;

@ExtendWith(MockitoExtension.class)
class GeonameServicesTest {

	@Mock
	private GeonameRepository geonameRepository;

	@InjectMocks
	private GeonameServices geonameServices;

	private GeoName sampleGeoName;

	@BeforeEach
	void setUp() {
		sampleGeoName = new GeoName(1L, "Test City", "Test", "Test Alternative", 10.0, 20.0, "P", "PPL", "ID", "",
				"Jakarta", 1L, 2L, "", 1000000L, 50L, 10L, "Asia/Jakarta", null);
	}

	@Test
	void testGetSuggestion_WhenNoMatch_ReturnsEmptyList() {
		when(geonameRepository.findByNameStartingWithIgnoreCase("Unknown"))
				.thenReturn(List.of());

		GeonameResponse response = geonameServices.getSuggestion("Unknown", null, null);

		assertNotNull(response);
		assertTrue(response.getSuggestions().isEmpty());
	}

	@Test
	void testGetSuggestion_WhenMatchesByName_ReturnsSortedList() {
		when(geonameRepository.findByNameStartingWithIgnoreCase("Test"))
				.thenReturn(List.of(sampleGeoName));

		GeonameResponse response = geonameServices.getSuggestion("Test", null, null);

		assertNotNull(response);
		assertFalse(response.getSuggestions().isEmpty());
		GeonameDTO suggestion = response.getSuggestions().get(0);
		assertEquals("Test City", suggestion.getName());
	}

	@Test
	void testGetSuggestion_WithLocationScore() {
		when(geonameRepository.findByNameStartingWithIgnoreCase("Test"))
				.thenReturn(List.of(sampleGeoName));

		GeonameResponse response = geonameServices.getSuggestion("Test", 10.0, 20.0);

		assertNotNull(response);
		assertFalse(response.getSuggestions().isEmpty());
		GeonameDTO suggestion = response.getSuggestions().get(0);
		assertEquals("Test City", suggestion.getName());
		assertEquals(10.0, suggestion.getLatitude());
		assertEquals(20.0, suggestion.getLongitude());
	}
}