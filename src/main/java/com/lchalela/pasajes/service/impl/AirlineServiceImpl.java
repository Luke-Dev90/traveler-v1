package com.lchalela.pasajes.service.impl;

import com.lchalela.pasajes.model.Airline;
import com.lchalela.pasajes.repository.AirlineRepository;
import com.lchalela.pasajes.service.AirlineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AirlineServiceImpl implements AirlineService {

    @Autowired
    private AirlineRepository airlineRepository;

    @Override
    public List<Airline> findAllAirline() {
        List<Airline> airlineList = airlineRepository.findAll();
        if(airlineList.isEmpty()){
            new Exception("List airline is empty");
        }
        return airlineList;
    }

    @Override
    public Airline findAirlineById(String id) throws Exception {
        Long idParse = 0l;
        try {
            idParse = Long.parseLong(id);
        }catch (NumberFormatException e){
            throw new NumberFormatException("Number id invalid");
        }
        Airline airline = airlineRepository.findById(idParse).orElseThrow(
                () -> {return new Exception("Airline not found");}
        );
        return airline;
    }

    @Override
    public void saveAirline(Airline airline) {
        airlineRepository.save(airline);
    }

    @Override
    public void updateAirline(Long id, Airline airline) {
        // TODO: 20/11/2021 need implements mapstruct 
    }

    @Override
    public void deleteAirlineById(String id) throws Exception {
        Airline airline = findAirlineById(id);
        airlineRepository.delete(airline);
    }
}