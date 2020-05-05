package com.meteo.ctask1;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class OpenWeatherResponseMapper {

    private final ObjectMapper objectMapper = new ObjectMapper();

    public WeatherDetails convertToObject(String openWeatherMapper) {
        try {
            Map map = objectMapper.readValue(openWeatherMapper, Map.class);
            Map mainFromJson = objectMapper.convertValue(map.get("main"), Map.class);

            float windSpeed = prepareWindSpeed(objectMapper.convertValue(map.get("wind"), Map.class));
            float minimumTemperature = prepareTempMin(mainFromJson);
            float maximumTemperature = prepareTempMax(mainFromJson);
            float atmosphericPressure = prepareAtmosphericPressure(mainFromJson);
            float feelsLike = prepareFeelsLike(mainFromJson);

            return WeatherDetails
                    .builder()
                    .windSpeed(windSpeed)
                    .minimumTemperature(minimumTemperature)
                    .maximumTemperature(maximumTemperature)
                    .atmosphericPressure(atmosphericPressure)
                    .feelsLikeTemperature(feelsLike)
                    .build();

        } catch (Exception e) {

        }

        return null;

    }

    private float prepareAtmosphericPressure(Map mainFromJson) {
        return Float.parseFloat(mainFromJson.get("pressure").toString());
    }

    private float prepareFeelsLike(Map mainFromJson) {
        return Float.parseFloat(mainFromJson.get("feels_like").toString());
    }

    private float prepareTempMax(Map mainFromJson) {
        return Float.parseFloat(mainFromJson.get("temp_max").toString());
    }

    private float prepareTempMin(Map mainFromJson) {
        return Float.parseFloat(mainFromJson.get("temp_min").toString());
    }

    private float prepareWindSpeed(Map wind) {
        return Float.parseFloat(wind.get("speed").toString());
    }
}
