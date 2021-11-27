package com.lchalela.pasajes.service;

import com.lchalela.pasajes.dto.CountryDTO;
import com.lchalela.pasajes.model.Country;

import java.util.List;

public interface CountryService {
    List<Country> findAllCountries();
    List<Country> findByName(String name);
    Country findCountryById(String id) throws Exception;
    void saveCountry(CountryDTO countryDTO) throws Exception;
    void updateCountry(String id,CountryDTO countryDTO) throws Exception;
}