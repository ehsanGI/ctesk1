package com.meteo.ctask1;

import lombok.RequiredArgsConstructor;
import org.apache.logging.log4j.util.Strings;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Component
public class WeatherService {

    private final OpenWeatherMapAdapter openWeatherMapAdapter;
    private final WeatherDetailsCache weatherDetailsCache;
    private final WeatherServiceHelper weatherServiceHelper;
    private final CityRepository cityRepository;

    public void update(String cityId) {
        openWeatherMapAdapter.getWeatherByCityId(cityId)
                .ifPresent(weatherDetails -> weatherDetailsCache.updateWeather(cityId, weatherDetails));
    }

    public Optional<WeatherDetails> getWeatherByCityId(String cityId) {
        return weatherDetailsCache.getWeather(cityId);
    }


    public Map<String, Object> lookup(String cityName, Set<String> params) {
        Optional<City> byName = cityRepository.findByName(cityName);
        if (byName.isPresent()) {
            Optional<WeatherDetails> weatherByCityId = getWeatherByCityId(byName.get().getId());
            WeatherDetails weatherDetails = weatherByCityId.get();
            return params.
                    stream()
                    .filter(Strings::isNotBlank)
                    .collect(Collectors.toMap(parameter -> parameter, parameter -> weatherServiceHelper.valueOf(weatherDetails, parameter)));
        }

        return Collections.emptyMap();
    }
}

