package com.meteo.ctask1;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

public class OpenWeatherResponseMapperTest {

    private final String openWeatherResponse = "{\"coord\":{\"lon\":21.01,\"lat\":52.23},\"weather\":[{\"id\":801,\"main\":\"Clouds\",\"description\":\"few clouds\",\"icon\":\"02d\"}],\"base\":\"stations\",\"main\":{\"temp\":283.7,\"feels_like\":280.12,\"temp_min\":282.15,\"temp_max\":285.37,\"pressure\":1011,\"humidity\":70},\"visibility\":10000,\"wind\":{\"speed\":3.6,\"deg\":310},\"clouds\":{\"all\":20},\"dt\":1588696147,\"sys\":{\"type\":1,\"id\":1713,\"country\":\"PL\",\"sunrise\":1588647441,\"sunset\":1588702070},\"timezone\":7200,\"id\":756135,\"name\":\"Warsaw\",\"cod\":200}";

    @Test
    public void wind_speed_should_be_mapped_from_the_open_weather_response() {

        // Given
        OpenWeatherResponseMapper openWeatherMapper = new OpenWeatherResponseMapper();

        // When
        WeatherDetails weatherDetails = openWeatherMapper.convertToObject(openWeatherResponse);

        // Then
        assertThat(weatherDetails.getWindSpeed()).isEqualTo(3.6f);
    }

    @Test
    public void minimum_temperature_should_be_mapped_from_the_open_weather_response() {

        // Given
        OpenWeatherResponseMapper openWeatherMapper = new OpenWeatherResponseMapper();

        // When
        WeatherDetails weatherDetails = openWeatherMapper.convertToObject(openWeatherResponse);

        // Then
        assertThat(weatherDetails.getMinimumTemperature()).isEqualTo(282.15f);
    }

    @Test
    public void maximum_temperature_should_be_mapped_from_the_open_weather_response() {

        // Given
        OpenWeatherResponseMapper openWeatherMapper = new OpenWeatherResponseMapper();

        // When
        WeatherDetails weatherDetails = openWeatherMapper.convertToObject(openWeatherResponse);

        // Then
        assertThat(weatherDetails.getMaximumTemperature()).isEqualTo(285.37f);
    }

    @Test
    public void feels_like_should_be_mapped_from_the_open_weather_response() {

        // Given
        OpenWeatherResponseMapper openWeatherMapper = new OpenWeatherResponseMapper();

        // When
        WeatherDetails weatherDetails = openWeatherMapper.convertToObject(openWeatherResponse);

        // Then
        assertThat(weatherDetails.getFeelsLikeTemperature()).isEqualTo(280.12f);
    }

    @Test
    public void atmospheric_pressure_should_be_mapped_from_the_open_weather_response() {

        // Given
        OpenWeatherResponseMapper openWeatherMapper = new OpenWeatherResponseMapper();

        // When
        WeatherDetails weatherDetails = openWeatherMapper.convertToObject(openWeatherResponse);

        // Then
        assertThat(weatherDetails.getAtmosphericPressure()).isEqualTo(1011f);
    }

}
