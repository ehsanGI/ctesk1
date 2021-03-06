package com.meteo.ctask1;

import lombok.RequiredArgsConstructor;

import java.util.Map;
import java.util.function.Function;

@RequiredArgsConstructor
public class WeatherServiceHelper {

    private final Map<String, Function<WeatherDetails, Object>> getters;

    public Object valueOf(WeatherDetails weatherDetails, String parameter) {
        return getters.get(parameter).apply(weatherDetails);
    }
}
