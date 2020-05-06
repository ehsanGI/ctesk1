package com.meteo.ctask1;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;

@Configuration
@EnableScheduling
@EnableSwagger2
@RequiredArgsConstructor
public class ApplicationConfig {

    @Bean
    public List<City> cities() {
        return Arrays.asList(
                City.builder().name("Warsaw").id("756135").build(),
                City.builder().name("Krakow").id("3094802").build(),
                City.builder().name("London").id("2643743").build()
        );
    }

    @Bean
    public WeatherServiceHelper weatherServiceHelper() {
        Map<String, Function<WeatherDetails, Object>> getters = new HashMap<>();
        getters.put("max_temp", WeatherDetails::getMaximumTemperature);
        getters.put("min_temp", WeatherDetails::getMinimumTemperature);
        getters.put("feels_like_temp", WeatherDetails::getFeelsLikeTemperature);
        getters.put("wind_speed", WeatherDetails::getWindSpeed);
        getters.put("atmospheric_pressure", WeatherDetails::getAtmosphericPressure);

        return new WeatherServiceHelper(getters);
    }

    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.any())
                .paths(PathSelectors.any())
                .build();
    }

}
