package com.jumia.jpay.jpayvalidator.repository;

import com.jumia.jpay.jpayvalidator.entity.Country;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CountryRepository extends JpaRepository<Country,Integer> {
}
