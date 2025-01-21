package com.hms.repository;

import com.hms.entity.Property;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface PropertyRepository extends JpaRepository<Property, Long> {

    @Query("SELECT  p FROM Property p JOIN p.city c JOIN p.country co WHERE c.name = :name or co.name =:name")
    List<Property> searchHotels(@Param("name") String name);

//   @Query("SELECT DISTINCT p FROM Property p JOIN p.country c WHERE LOWER (c.name) = LOWER(:country)")
//    List<Property> searchCountryHotels(@Param("country") String countryName);




}