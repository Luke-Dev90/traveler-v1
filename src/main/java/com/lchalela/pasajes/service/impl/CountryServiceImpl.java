package com.lchalela.pasajes.service.impl;

import com.lchalela.pasajes.dto.CountryDTO;
import com.lchalela.pasajes.mapper.AirlineMapper;
import com.lchalela.pasajes.mapper.CountryMapper;
import com.lchalela.pasajes.mapper.HotelMapper;
import com.lchalela.pasajes.model.Airline;
import com.lchalela.pasajes.model.Country;
import com.lchalela.pasajes.model.Hotel;
import com.lchalela.pasajes.repository.AirlineRepository;
import com.lchalela.pasajes.repository.CountryRepository;
import com.lchalela.pasajes.service.AirlineService;
import com.lchalela.pasajes.service.CountryService;
import com.lchalela.pasajes.service.HotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class CountryServiceImpl implements CountryService {

    @Autowired
    private CountryRepository countryRepository;

    @Autowired
    private CountryMapper countryMapper;

    @Autowired
    private AirlineService airlineService;

    @Autowired
    private AirlineMapper airlineMapper;

    @Autowired
    private AirlineRepository airlineRepository;

    @Override
    public List<Country> findAllCountries() {
        List<Country> countryDTOList =countryRepository.findAll();
        if(countryDTOList.isEmpty()){
            new Exception("List Countries is empty");
        }
        return countryDTOList;
    }

    @Override
    public List<Country> findByName(String name) {
        List<Country> list = countryRepository.getCountryByName(name);
        if(list.isEmpty()){
            new Exception("Country not exist");
        }
        return list;
    }

    @Override
    public Country findCountryById(String id) throws Exception {
        Long idParse = 0l;
        try {
            idParse = Long.parseLong(id);
        }catch (NumberFormatException ex){
            new NumberFormatException("The id is invalid");
        }
        return countryRepository.findById(idParse)
                .orElseThrow(() -> { return new Exception("Country not exist");});
    }

    @Override
    public void saveCountry(CountryDTO countryDTO) throws Exception {
        Airline airline = airlineRepository.findById(countryDTO.getAirlineId()).orElseThrow(
                ()-> new Exception("Airline not found")
        );
        Country country = countryMapper.toEntity(countryDTO);
        country.setAirline(airline);
        countryRepository.save(country);
    }

    @Override
    public void updateCountry(String id, CountryDTO countryDTO) throws Exception {
        Long idParse = 0l;
        try{
            idParse = Long.parseLong(id);
        }catch(NumberFormatException ef){
            new NumberFormatException("Country not found");
        }
        Country country = countryRepository.findById(idParse).orElseThrow(
                ()-> new Exception("Country not found")
        );
        countryMapper.updateEntity(countryDTO,country);
        Airline airline = airlineRepository.findById(countryDTO.getAirlineId())
                .orElseThrow( () ->new Exception("Airline not found"));
        country.setAirline(airline);
        countryRepository.save(country);
    }
}