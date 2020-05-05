package com.meteo.ctask1;

import java.util.List;
import java.util.Optional;

public interface CityRepository {
    Optional<City> findByName(String cityName);

    List<City> findAll();
}
