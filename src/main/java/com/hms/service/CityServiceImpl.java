package com.hms.service;

import com.hms.entity.City;
import com.hms.exception.CityException;
import com.hms.repository.CityRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CityServiceImpl implements CityService {

    private CityRepository cityRepository;

    public CityServiceImpl(CityRepository cityRepository) {
        this.cityRepository = cityRepository;
    }

    @Override
    public City saveCity(City city){
        City savedCity = cityRepository.save(city);
        return savedCity;
    }

    @Override
    public List<City> getAllCities(){
        return  cityRepository.findAll();

    }

    @Override
    public City updateCities(Long id, City city) throws CityException{
        Optional<City> opCities = cityRepository.findById(id);
        if(opCities.isEmpty()){
            throw new CityException("City is Not Found This Id " + id);
        }
        City existingCities = opCities.get();

        existingCities.setName(city.getName());
        City savedCities = cityRepository.save(existingCities);
        return savedCities;
    }

    @Override
    public void deleteCity(Long id) throws CityException{
        cityRepository.deleteById(id);
    }

    @Override
    public City getCityById(Long id){
        return cityRepository.findById(id).orElseThrow(()-> new CityException("City Not Found This Id : "+ id));
    }
}
