package com.meteo.ctask1;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class WeatherDetails {

    private final float windSpeed;
    private final float atmosphericPressure;
    private final float feelsLikeTemperature;
    private final float maximumTemperature;
    private final float minimumTemperature;

}
