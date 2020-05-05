package com.meteo.ctask1;

import org.springframework.stereotype.Component;

import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;

@Component
public class InMemoryWeatherDetailsCache implements WeatherDetailsCache {

    private Map<String, WeatherDetails> weatherDetailsMap = new ConcurrentHashMap<>();

    @Override
    public void updateWeather(String cityId, WeatherDetails weatherDetails) {
        weatherDetailsMap.put(cityId, weatherDetails);
    }

    @Override
    public Optional<WeatherDetails> getWeather(String cityId) {
        return Optional.ofNullable(weatherDetailsMap.get(cityId));
    }
}
