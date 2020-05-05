package com.meteo.ctask1;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiParam;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;
import java.util.Set;

@RestController
@RequiredArgsConstructor
@Api(description = "valid params are: max_temp, min_temp, feels_like_temp, wind_speed, atmospheric_pressure")
public class MeteoTask1Controller {

    private final CityRepository cityRepository;
    private final WeatherService weatherService;


    @GetMapping("/weather/{cityName}")
    public Map<String, Object> weatherLookup(
            @PathVariable String cityName,
            @RequestParam Set<String> params) {

        return weatherService.lookup(cityName, params);
    }
}
