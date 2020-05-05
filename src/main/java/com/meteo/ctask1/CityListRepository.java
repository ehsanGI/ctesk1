package com.meteo.ctask1;

import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class CityListRepository implements CityRepository {

    private final List<City> cities;

    public CityListRepository(List<City> cities) {
        this.cities = cities;
    }

    @Override
    public Optional<City> findByName(String cityName) {
        return cities
                .stream()
                .filter(city -> city.getName().toUpperCase().equals(cityName.toUpperCase()))
                .findAny();
    }

    @Override
    public List<City> findAll() {
        return cities;
    }
}
