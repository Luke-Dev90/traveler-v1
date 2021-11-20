package com.lchalela.pasajes.service;

import com.lchalela.pasajes.model.Airline;

import java.util.List;

public interface AirlineService {
    List<Airline> findAllAirline();
    Airline findAirlineById(String id) throws Exception;
    void saveAirline(Airline airline);
    void updateAirline(Long id,Airline airline);
    void deleteAirlineById(String id) throws Exception;
}