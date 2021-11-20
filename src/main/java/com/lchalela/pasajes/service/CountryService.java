package com.lchalela.pasajes.service;

import com.lchalela.pasajes.model.Country;

import java.util.List;

public interface CountryService {
    List<Country> findAllCountries();
    List<Country> findByName(String name);
    Country findCountryById(Long id);
    void saveCountry(Country country);
    void updateCountry(Long id,Country country);
    void deleteCountryById(Long id);
}