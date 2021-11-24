package com.lchalela.pasajes.service;

import com.lchalela.pasajes.dto.CountryDTO;
import com.lchalela.pasajes.model.Country;

import java.util.List;

public interface CountryService {
    List<CountryDTO> findAllCountries();
    List<CountryDTO> findByName(String name);
    CountryDTO findCountryById(String id) throws Exception;
    void saveCountry(CountryDTO countryDTO);
    void updateCountry(String id,CountryDTO countryDTO) throws Exception;
    void deleteCountryById(String id) throws Exception;
}