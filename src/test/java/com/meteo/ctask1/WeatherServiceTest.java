package com.meteo.ctask1;

import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

public class WeatherServiceTest {

    @Test
    public void after_updating_cache_should_be_updated_properly() {

        // Given
        final String cityId = "123123";
        OpenWeatherMapAdapter openWeatherMapAdapterMock = mock(OpenWeatherMapAdapter.class);
        WeatherDetailsCache weatherDetailsCache = mock(WeatherDetailsCache.class);
        WeatherDetails weatherDetails = WeatherDetails.builder().build();

        when(openWeatherMapAdapterMock.getWeatherByCityId(anyString())).thenReturn(Optional.of(weatherDetails));
        doNothing().when(weatherDetailsCache).updateWeather(anyString(), any(WeatherDetails.class));

        WeatherService weatherService = new WeatherService(openWeatherMapAdapterMock, weatherDetailsCache, null, null);

        // When
        weatherService.update(cityId);

        // Then
        verify(weatherDetailsCache).updateWeather(eq(cityId), eq(weatherDetails));
    }

    @Test
    public void weather_service_should_get_weather_by_city_id_from_cache () {

        // Given
        final String cityId = "123123";
        WeatherDetails weatherDetails = WeatherDetails.builder().build();
        OpenWeatherMapAdapter openWeatherMapAdapterMock = mock(OpenWeatherMapAdapter.class);
        WeatherDetailsCache weatherDetailsCache = mock(WeatherDetailsCache.class);

        when(weatherDetailsCache.getWeather(cityId)).thenReturn(Optional.of(weatherDetails));
        WeatherService weatherService = new WeatherService(openWeatherMapAdapterMock, weatherDetailsCache, null, null);

        // When
        Optional<WeatherDetails> weatherByCityId = weatherService.getWeatherByCityId(cityId);

        // Then
        assertThat(weatherByCityId).isPresent();
        assertThat(weatherByCityId.get()).isEqualTo(weatherDetails);
    }

}
