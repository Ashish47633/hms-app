package com.hms.service;

import com.hms.entity.Country;

import java.util.List;

public interface CountryService {
    Country addCountry(Country country);
    void deleteCountry(Long id);
    Country updateCountry(Long id, Country country);
    List<Country> getAllCountry();
    Country getCountryById(Long id);
}
