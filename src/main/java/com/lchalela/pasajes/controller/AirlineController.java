package com.lchalela.pasajes.controller;

import com.lchalela.pasajes.dto.AirlineDTO;
import com.lchalela.pasajes.service.AirlineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/airlines")
public class AirlineController {

    @Autowired
    private AirlineService airlineService;

    private Map<String,Object> response = new HashMap<>();

    @GetMapping("/all")
    private ResponseEntity<?> getAllAirline(){
        response.clear();
        response.put("Airlines",airlineService.findAllAirline());
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("{id}")
    private ResponseEntity<?> getAirlineById(@PathVariable String id) throws Exception {
        response.clear();
        response.put("Airline",airlineService.findAirlineById(id));
        return new ResponseEntity<>(response,HttpStatus.OK);
    }

    @PostMapping("/new")
    private ResponseEntity<?> newAirline(@Valid @RequestBody AirlineDTO airlineDTO){
        response.clear();
        airlineService.saveAirline(airlineDTO);
        response.put("message","Save airline successfully");
        return new ResponseEntity<>(response,HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    private ResponseEntity<?> updateAirline(@Valid @RequestBody AirlineDTO airlineDTO, @PathVariable String id)
            throws Exception {
        response.clear();
        airlineService.updateAirline(id,airlineDTO);
        response.put("message","Update Successfully");
        return new ResponseEntity<>(response,HttpStatus.ACCEPTED);
    }

    @DeleteMapping("/{id}")
    private ResponseEntity<?> deleteAirline(@PathVariable String id) throws Exception {
        response.clear();
        airlineService.deleteAirlineById(id);
        response.put("message","Airline deleted successfully");
        return new ResponseEntity<>(response,HttpStatus.OK);
    }
}