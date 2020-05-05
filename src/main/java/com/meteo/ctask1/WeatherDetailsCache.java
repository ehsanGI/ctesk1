package com.meteo.ctask1;

import java.util.Optional;

public interface WeatherDetailsCache {

    void updateWeather(String cityId, WeatherDetails weatherDetails);

    Optional<WeatherDetails> getWeather(String cityId);
}
