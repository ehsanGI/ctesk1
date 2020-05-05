package com.meteo.ctask1;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

public class CityListRepositoryTest {

    @Test
    public void not_found_city_should_return_empty_result() {

        // Given
        CityRepository cityRepository = new CityListRepository(Collections.emptyList());

        //When
        Optional<City> cityByName = cityRepository.findByName("Not_existing_city");

        //Then
        assertThat(cityByName).isNotPresent();
    }

    @Test
    public void existing_city_should_be_returned() {
        // Given
        final String krakowId = "3094802";
        List<City> cities = Arrays.asList(
                City.builder().name("Krakow").id(krakowId).build(),
                City.builder().name("Warszawa").id("756135").build()
        );
        CityRepository cityRepository = new CityListRepository(cities);

        //When
        Optional<City> cityByName = cityRepository.findByName("Krakow");

        //Then
        assertThat(cityByName).isPresent();
        assertThat(cityByName.get().getId()).isEqualTo(krakowId);
    }

    @Test
    public void city_name_should_not_be_case_sensitive() {
        // Given
        final String krakowId = "3094802";
        List<City> cities = Arrays.asList(
                City.builder().name("Krakow").id(krakowId).build(),
                City.builder().name("Warszawa").id("756135").build()
        );
        CityRepository cityRepository = new CityListRepository(cities);

        //When
        Optional<City> cityByName = cityRepository.findByName("krAkOw");

        //Then
        assertThat(cityByName).isPresent();
        assertThat(cityByName.get().getId()).isEqualTo(krakowId);
    }
}
