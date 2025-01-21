package com.hms.service;

import com.hms.entity.Property;

import java.util.List;

public interface PropertyService {
    Property addDetails(Property property);
    List<Property> getAllDetails();
    Property updateProperty(Long id , Property property);
    void deleteProperty(Long id);
    List<Property> searchHotels(String name);
}
