package com.meteo.ctask1;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Optional;

@RequiredArgsConstructor
@Component
public class OpenWeatherMapAdapter {

    private final OpenWeatherMapClient openWeatherMapClient;
    private final OpenWeatherResponseMapper openWeatherResponseMapper;

    private String appId = "d33f86f13c3240f09b02490ba43808b6";

    public Optional<WeatherDetails> getWeatherByCityId(String cityId) {
        try {
            Optional<String> weatherByCityId = openWeatherMapClient.getWeatherByCityId(appId, cityId);
            if (weatherByCityId.isPresent()) {
                return Optional.of(openWeatherResponseMapper.convertToObject(weatherByCityId.get()));
            }
        } catch (Exception e) {
            // todo logging needed
        }

        return Optional.empty();
    }
}
