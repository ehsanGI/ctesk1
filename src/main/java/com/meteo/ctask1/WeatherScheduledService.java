package com.meteo.ctask1;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.Scheduled;

@RequiredArgsConstructor
@Configuration
public class WeatherScheduledService {

    private final WeatherService weatherService;
    private final CityRepository cityRepository;

    @Scheduled(fixedDelay = 1000 * 60 * 10)
    public void updateWeather() {
        cityRepository.findAll().stream().map(City::getId).forEach(weatherService::update);
    }
}
