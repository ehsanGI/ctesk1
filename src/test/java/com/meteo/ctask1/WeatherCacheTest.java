package com.meteo.ctask1;

import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

public class WeatherCacheTest {

    @Test
    public void new_data_should_be_cached() {

        // Given
        final String cityId = "123123";
        final float windSpeed = 2.6f;
        WeatherDetails weatherDetails = WeatherDetails.builder().windSpeed(windSpeed).build();
        WeatherDetailsCache weatherDetailsCache = new InMemoryWeatherDetailsCache();

        // When
        weatherDetailsCache.updateWeather(cityId, weatherDetails);

        // Then
        Optional<WeatherDetails> weatherDetailsFromCache = weatherDetailsCache.getWeather(cityId);

        assertThat(weatherDetailsFromCache).isPresent();
        assertThat(weatherDetails.getWindSpeed()).isEqualTo(windSpeed);
    }

    @Test
    public void new_data_should_be_overwrite() {

        // Given
        final String cityId = "123123";
        final float windSpeed = 2.6f;
        WeatherDetails weatherDetails = WeatherDetails.builder().windSpeed(windSpeed).build();
        WeatherDetailsCache weatherDetailsCache = new InMemoryWeatherDetailsCache();
        weatherDetailsCache.updateWeather(cityId, weatherDetails);

        // When
        final float newWindSpeed = 12.6f;
        WeatherDetails newWeatherDetails = WeatherDetails.builder().windSpeed(newWindSpeed).build();
        weatherDetailsCache.updateWeather(cityId, newWeatherDetails);

        // Then
        Optional<WeatherDetails> weatherDetailsFromCache = weatherDetailsCache.getWeather(cityId);

        assertThat(weatherDetailsFromCache).isPresent();
        assertThat(weatherDetailsFromCache.get().getWindSpeed()).isEqualTo(newWindSpeed);
    }
}
