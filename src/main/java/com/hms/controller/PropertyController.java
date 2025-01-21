package com.hms.controller;

import com.hms.entity.Property;
import com.hms.repository.PropertyRepository;
import com.hms.service.PropertyService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/property")
public class PropertyController {

    private PropertyRepository propertyRepository;
    private PropertyService propertyService;

    public PropertyController(PropertyRepository propertyRepository, PropertyService propertyService) {
        this.propertyRepository = propertyRepository;
        this.propertyService = propertyService;
    }

    @GetMapping("/search-hotels")
    public ResponseEntity<List<Property>> searchHotels(@RequestParam String name){
        //return propertyRepository.searchHotels(cityName);
        List<Property> properties = propertyService.searchHotels(name);
        return new ResponseEntity<>(properties,HttpStatus.OK);
    }

//    @GetMapping("/search-country-hotels")
//    public List<Property> searchCountryHotels(@RequestParam String countryName){
//        return propertyRepository.searchCountryHotels(countryName);
//
//    }

    @PostMapping("/addProperty")
    public ResponseEntity<Property> addProperty(@RequestBody Property property){
        Property p = propertyService.addDetails(property);
        return new ResponseEntity<>(p,HttpStatus.CREATED);

    }

    @GetMapping("/allDetails")
    public ResponseEntity<List<Property>> getAllDetails(){
        List<Property> allDetails = propertyService.getAllDetails();
        return new ResponseEntity<>(allDetails,HttpStatus.OK);

    }

    @PutMapping("/updateProperty/{id}")
    public ResponseEntity<Property> updateProperty(@PathVariable Long id, @RequestBody Property property){
        Property updateProp = propertyService.updateProperty(id, property);
        return new ResponseEntity<>(updateProp,HttpStatus.OK);
    }

    @DeleteMapping("/delete-property/{id}")
    public ResponseEntity<String> deleteProperty(@PathVariable Long id){
        try{
            propertyService.deleteProperty(id);
            return new ResponseEntity<>("Deleted Successfully This Id no : "+id,HttpStatus.OK);
        }catch(RuntimeException e){
            return new ResponseEntity<>("Failed to Deleted"+ e.getMessage(),HttpStatus.BAD_REQUEST);
        }
    }


}
