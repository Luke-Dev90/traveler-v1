package com.lchalela.pasajes.mapper;

import com.lchalela.pasajes.dto.AirlineDTO;
import com.lchalela.pasajes.model.Airline;
import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

import java.util.List;

@Mapper(componentModel = "spring")
public interface AirlineMapper {
    Airline toEntity(AirlineDTO airlineDTO);
    AirlineDTO toDTO(Airline airline);
    List<AirlineDTO> toListDTO(List<Airline> airlineList);
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void updateEntity(AirlineDTO airlineDTO,@MappingTarget Airline airline);
}