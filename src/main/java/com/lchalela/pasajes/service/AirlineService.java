package com.lchalela.pasajes.service;

import com.lchalela.pasajes.dto.AirlineDTO;
import com.lchalela.pasajes.model.Airline;

import java.util.List;

public interface AirlineService {
    List<AirlineDTO> findAllAirline();
    AirlineDTO findAirlineById(String id) throws Exception;
    void saveAirline(AirlineDTO airlineDTO);
    void updateAirline(String id,AirlineDTO airline) throws Exception;
    void deleteAirlineById(String id) throws Exception;
}