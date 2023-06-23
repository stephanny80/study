package com.example.api.repository;

import com.example.api.data.Country;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Component;

@Component
public interface CountryRepository extends JpaRepository<Country, Long> {

    Country findByName(@Param("name") String name);

    Country findFirstByOrderByIdDesc();
}
