package com.lchalela.pasajes.mapper;

import com.lchalela.pasajes.dto.AirlineDTO;
import com.lchalela.pasajes.model.Airline;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface AirlineMapper {
    Airline toEntity(AirlineDTO airlineDTO);
    AirlineDTO toDTO(Airline airline);
    List<AirlineDTO> toListDTO(List<Airline> airlineList);
    Airline updateEntity(AirlineDTO airlineDTO,Airline airline);
}