package com.lchalela.pasajes.service.impl;

import com.lchalela.pasajes.dto.AirlineDTO;
import com.lchalela.pasajes.mapper.AirlineMapper;
import com.lchalela.pasajes.model.Airline;
import com.lchalela.pasajes.repository.AirlineRepository;
import com.lchalela.pasajes.service.AirlineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AirlineServiceImpl implements AirlineService {

    @Autowired
    private AirlineRepository airlineRepository;

    @Autowired
    private AirlineMapper airlineMapper;

    @Override
    public List<AirlineDTO> findAllAirline() {
        List<AirlineDTO> airlineList = airlineMapper.toListDTO(airlineRepository.findAll());
        if(airlineList.isEmpty()){
            new Exception("List airline is empty");
        }
        return airlineList;
    }

    @Override
    public AirlineDTO findAirlineById(String id) throws Exception {
        Long idParse = 0l;
        try {
            idParse = Long.parseLong(id);
        }catch (NumberFormatException e){
            throw new NumberFormatException("Number id invalid");
        }
        AirlineDTO airline = airlineMapper.toDTO(airlineRepository.findById(idParse).orElseThrow(
                () -> {return new Exception("Airline not found");}
        ));
        return airline;
    }

    @Override
    public void saveAirline(AirlineDTO airlineDTO) {
        Airline airline = airlineMapper.toEntity(airlineDTO);
        airlineRepository.save(airline);
    }

    @Override
    public void updateAirline(String id, AirlineDTO airlineDTO) throws Exception {
        Long idParse = 0l;
        try{
            idParse = Long.parseLong(id);
        }catch (NumberFormatException ef){
            new NumberFormatException("The format invalid");
        }
        Airline airline = airlineRepository.findById(idParse).orElseThrow(
                () -> {return new Exception("Airline not found");}
        );
        airlineMapper.updateEntity(airlineDTO,airline);
        airlineRepository.save(airline);
    }

    @Override
    public void deleteAirlineById(String id) throws Exception {
        Long idParse = 0l;
        try {
            idParse = Long.parseLong(id);
        }catch (NumberFormatException ef){
            new NumberFormatException("Invalid format exception");
        }
        Airline airline = airlineRepository.findById(idParse).orElseThrow(
                ()->{return new Exception("Airline not found");}
        );
        airlineRepository.delete(airline);
    }
}