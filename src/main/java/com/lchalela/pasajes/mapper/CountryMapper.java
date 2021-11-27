package com.lchalela.pasajes.mapper;

import com.lchalela.pasajes.dto.CountryDTO;
import com.lchalela.pasajes.model.Country;
import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CountryMapper {
    Country toEntity(CountryDTO countryDTO);
    CountryDTO toDTO(Country country);
    List<CountryDTO> toListDTO(List<Country> countryList);
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    Country updateEntity(CountryDTO countryDTO,@MappingTarget Country country);
}