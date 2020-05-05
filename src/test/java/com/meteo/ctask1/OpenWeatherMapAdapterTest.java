package com.meteo.ctask1;

import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.*;

public class OpenWeatherMapAdapterTest {

    @Test
    public void after_updating_cache_should_be_updated_properly() {

        // Given
        final String cityId = "123123";
        final String responseStr = "responseStr";
        WeatherDetails weatherDetails = WeatherDetails.builder().build();
        OpenWeatherMapClient openWeatherMapClient = mock(OpenWeatherMapClient.class);
        OpenWeatherResponseMapper openWeatherResponseMapper = mock(OpenWeatherResponseMapper.class);

        when(openWeatherMapClient.getWeatherByCityId(anyString(), anyString())).thenReturn(Optional.of(responseStr));
        when(openWeatherResponseMapper.convertToObject(anyString())).thenReturn(weatherDetails);

        OpenWeatherMapAdapter openWeatherMapAdapter =
                new OpenWeatherMapAdapter(openWeatherMapClient, openWeatherResponseMapper);

        // When
        Optional<WeatherDetails> weatherByCityId = openWeatherMapAdapter.getWeatherByCityId(cityId);

        // Then
        assertThat(weatherByCityId).isPresent();
        assertThat(weatherByCityId.get()).isEqualTo(weatherDetails);
        verify(openWeatherResponseMapper).convertToObject(eq(responseStr));
    }
}
