package com.meteo.ctask1;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Optional;

@FeignClient(
        name = "OpenWeatherMapClient",
        url = "https://api.openweathermap.org/data/2.5"
)
public interface OpenWeatherMapClient {

    @GetMapping("/weather")
    Optional<String> getWeatherByCityId( @RequestParam("APPID") String apiId, @RequestParam("id") String cityId);
}
