package com.hms.service;

import com.hms.entity.City;

import java.util.List;


public interface CityService {
    City saveCity(City city);
    List<City> getAllCities();
    City updateCities(Long id, City city);
    void deleteCity(Long id);
    City getCityById(Long id);
}
