package com.meteo.ctask1;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(classes = Application.class)
public class OpenWeatherMapClientItTest {

    @Autowired
    private OpenWeatherMapClient openWeatherMapClient;

    @Test
    public void open_weather_for_krakow_should_be_found() {

        // Given
        String krakowCityId = "3094802";

        // When
        Optional<String> weatherByCityId = openWeatherMapClient.getWeatherByCityId("d33f86f13c3240f09b02490ba43808b6", krakowCityId);

        // Then
        assertThat(weatherByCityId).isPresent();
    }
}
