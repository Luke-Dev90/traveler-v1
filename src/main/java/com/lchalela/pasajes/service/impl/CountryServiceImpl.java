package com.lchalela.pasajes.service.impl;

import com.lchalela.pasajes.dto.CountryDTO;
import com.lchalela.pasajes.mapper.AirlineMapper;
import com.lchalela.pasajes.mapper.CountryMapper;
import com.lchalela.pasajes.model.Airline;
import com.lchalela.pasajes.model.Country;
import com.lchalela.pasajes.repository.CountryRepository;
import com.lchalela.pasajes.service.AirlineService;
import com.lchalela.pasajes.service.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

    @Override
    public List<CountryDTO> findAllCountries() {
        List<CountryDTO> countryDTOList = countryMapper.toListDTO(countryRepository.findAll());
        if(countryDTOList.isEmpty()){
            new Exception("List Countries is empty");
        }
        return countryDTOList;
    }

    @Override
    public List<CountryDTO> findByName(String name) {
        List<CountryDTO> list = countryMapper.toListDTO(countryRepository.getCountryByName(name));
        if(list.isEmpty()){
            new Exception("Country not exist");
        }
        return list;
    }

    @Override
    public CountryDTO findCountryById(String id) throws Exception {
        Long idParse = 0l;
        try {
            idParse = Long.parseLong(id);
        }catch (NumberFormatException ex){
            new NumberFormatException("The id is invalid");
        }
        return countryMapper.toDTO( countryRepository.findById(idParse).orElseThrow(
                () -> { return new Exception("Country not exist");}
        ));
    }

    @Override
    public void saveCountry(CountryDTO countryDTO) {
        countryRepository.save(countryMapper.toEntity(countryDTO));
    }

    @Override
    public void updateCountry(String id, CountryDTO countryDTO) throws Exception {
        Country country = countryMapper.toEntity(findCountryById(id));
        countryMapper.updateEntity(countryDTO,country);
        Airline airline = airlineMapper.toEntity(airlineService
                .findAirlineById(String.valueOf(countryDTO.getAirlineId())));
        country.setAirline(airline);
        countryRepository.save(country);
    }

    @Override
    public void deleteCountryById(String id) throws Exception {
        Country country = countryMapper.toEntity(findCountryById(id));
        if(country.getAirline() != null){
            airlineService.deleteAirlineById(String.valueOf(country.getAirline().getId()));
        }
        countryRepository.delete(country);
    }
}