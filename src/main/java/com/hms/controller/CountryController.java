package com.hms.controller;

import com.hms.entity.Country;
import com.hms.service.CountryService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/country")
public class CountryController {

    private CountryService countryService;

    public CountryController(CountryService countryService) {
        this.countryService = countryService;
    }

    @PostMapping("/addCountry")
    public ResponseEntity<Country> addCountry(@RequestBody Country country){
        Country add = countryService.addCountry(country);
        return new ResponseEntity<>(add, HttpStatus.CREATED);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteCountry(@PathVariable Long id){
        try{
            countryService.deleteCountry(id);
            return new ResponseEntity<>("Country is Deleted This Id : "+id, HttpStatus.OK);
        }catch(RuntimeException e){
            return new ResponseEntity<>("Failed to Deleted Country " +e.getMessage(),HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Country> updateCountry(@PathVariable Long id, @RequestBody Country country){
        Country updateCountry = countryService.updateCountry(id, country);
        return new ResponseEntity<>(updateCountry,HttpStatus.OK);
    }

    @GetMapping("/allCountry")
    public ResponseEntity<List<Country>> getAllCountry(){
        List<Country> allCountry = countryService.getAllCountry();
        return new ResponseEntity<>(allCountry,HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Country> getCountryById(@PathVariable Long id){
        Country countryById = countryService.getCountryById(id);
        return new ResponseEntity<>(countryById, HttpStatus.OK);
    }
}
