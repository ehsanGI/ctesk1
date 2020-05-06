package com.meteo.ctask1;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class WeatherServiceHelperTest {

    @Test
    public void max_temp_should_return_maximum_tempreture() {
        // Given
        ApplicationConfig applicationConfig = new ApplicationConfig();
        WeatherServiceHelper helper = applicationConfig.weatherServiceHelper();
        WeatherDetails weatherDetails = WeatherDetails.builder().maximumTemperature(11f).build();

        // When
        Object maxTemp = helper.valueOf(weatherDetails, "max_temp");

        // Then
        assertThat(maxTemp).isEqualTo(11f);


    }
}
