package com.lchalela.pasajes.service;

import com.lchalela.pasajes.model.Airline;

import java.util.List;

public interface AirlineService {
    List<Airline> findAllAirline();
    Airline findAirlineById(Long id);
    void saveAirline(Airline airline);
    void updateAirline(Long id,Airline airline);
    void deleteAirlineById(Long id);
}