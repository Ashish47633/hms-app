package com.hms.service;

import com.hms.entity.Property;
import com.hms.exception.PropertyException;
import com.hms.repository.PropertyRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PropertyServiceImpl implements PropertyService{

    private PropertyRepository propertyRepository;

    public PropertyServiceImpl(PropertyRepository propertyRepository) {
        this.propertyRepository = propertyRepository;
    }

    @Override
    public Property addDetails( Property property){
        Property saved = propertyRepository.save(property);
        return saved;

    }

    @Override
    public List<Property> getAllDetails(){
         return  propertyRepository.findAll();
    }

    @Override
    public Property updateProperty(Long id, Property property) throws PropertyException{
        Optional<Property> opProperty = propertyRepository.findById(id);
        if(opProperty.isEmpty()){
            throw new PropertyException("City/Country is Not Present This Id No " +id);
        }
        Property prop = opProperty.get();
        prop.setName(property.getName());
        prop.setNo_of_bathrooms(property.getNo_of_bathrooms());
        prop.setNo_of_bedrooms(property.getNo_of_bedrooms());
        prop.setNo_of_beds(property.getNo_of_beds());
        prop.setNo_of_guest(property.getNo_of_guest());
        prop.setCity(property.getCity());
        prop.setCountry(property.getCountry());
        Property savedPropetry = propertyRepository.save(prop);
        return savedPropetry;

    }

    @Override
    public void deleteProperty(Long id){
        propertyRepository.deleteById(id);
    }

    @Override
    public List<Property> searchHotels(String name) throws PropertyException{
        List<Property> findHotelsName = propertyRepository.searchHotels(name);
        if(findHotelsName.isEmpty()){
            throw new PropertyException("City and Country is Not Present This name");
        }
        return findHotelsName;

    }
}
