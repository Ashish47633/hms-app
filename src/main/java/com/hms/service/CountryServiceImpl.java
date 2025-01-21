package com.hms.service;

import com.hms.entity.Country;
import com.hms.exception.CountryException;
import com.hms.repository.CountryRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CountryServiceImpl implements CountryService{

    private CountryRepository countryRepository;

    public CountryServiceImpl(CountryRepository countryRepository) {
        this.countryRepository = countryRepository;
    }

    @Override
    public Country addCountry(Country country){
        Country savedCountry = countryRepository.save(country);
        return savedCountry;
    }

    @Override
    public void deleteCountry(Long id){
        countryRepository.deleteById(id);
    }

    @Override
    public Country updateCountry(Long id , Country country) throws CountryException {
        Optional<Country> opCountry = countryRepository.findById(id);
        if(opCountry.isEmpty()){
            throw new CountryException("Country is Not Present This Id No : " +id);
        }
        Country update = opCountry.get();
        update.setName(country.getName());
        Country savedCountry = countryRepository.save(update);
        return savedCountry;
    }

    @Override
    public List<Country> getAllCountry(){
        return  countryRepository.findAll();
    }

    @Override
    public Country getCountryById(Long id){
        return countryRepository.findById(id).orElseThrow(()-> new CountryException("Country is Not Present This Id No : "));

    }
}
