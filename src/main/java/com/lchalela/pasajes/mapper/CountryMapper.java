package com.lchalela.pasajes.mapper;

import com.lchalela.pasajes.dto.CountryDTO;
import com.lchalela.pasajes.model.Country;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CountryMapper {
    Country toEntity(CountryDTO countryDTO);
    CountryDTO toDTO(Country country);
    List<CountryDTO> toListDTO(List<Country> countryList);
    Country updateEntity(CountryDTO countryDTO,Country country);
}