package com.hms.controller;

import com.hms.entity.City;
import com.hms.service.CityService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/cities")
public class CityController {

    private CityService cityService;

    public CityController(CityService cityService) {
        this.cityService = cityService;
    }

    @PostMapping
    public ResponseEntity<City> saveCity(@RequestBody City city){
        City saveCity = cityService.saveCity(city);
        return new ResponseEntity<>(saveCity, HttpStatus.OK);
    }

    @GetMapping("/listAll")
    public ResponseEntity<List<City>> getAllCities(){
        List<City> allCities = cityService.getAllCities();
        return new ResponseEntity<>(allCities,HttpStatus.OK);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<City> updateCities(@PathVariable Long id, @RequestBody City city){
        City updateCities = cityService.updateCities(id, city);
        return new ResponseEntity<>(updateCities,HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteCities(@PathVariable Long id) {
        try {
            cityService.deleteCity(id);
            return new ResponseEntity<>("City deleted successfully with ID:" + id,HttpStatus.OK);
        } catch (RuntimeException e) {
            return new ResponseEntity<>("Failed to Deleted City : " + e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<City> getCityById(@PathVariable Long id){
        City cityById = cityService.getCityById(id);
        return new ResponseEntity<>(cityById,HttpStatus.BAD_REQUEST);
    }
}
