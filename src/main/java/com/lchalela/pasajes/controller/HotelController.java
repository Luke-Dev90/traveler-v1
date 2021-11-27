package com.lchalela.pasajes.controller;

import com.lchalela.pasajes.dto.HotelDTO;
import com.lchalela.pasajes.service.HotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/hotel")
public class HotelController {

    @Autowired
    private HotelService hotelService;

    private Map<String,Object> response = new HashMap<>();

    @GetMapping("/all")
    private ResponseEntity<?> getAllHotel(){
        response.clear();
        response.put("Hotels",hotelService.findAllHotel());
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    private ResponseEntity<?> getHotelById(@PathVariable String id) throws Exception {
        response.clear();
        response.put("Hotel",hotelService.findHotelById(id));
        return new ResponseEntity<>(response,HttpStatus.OK);
    }

    @PostMapping("/save")
    private ResponseEntity<?> saveHotel(@Valid @RequestBody HotelDTO hotelDTO) throws Exception {
        response.clear();
        hotelService.saveHotel(hotelDTO);
        response.put("message","Hotel created successfully");
        return new ResponseEntity<>(response,HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    private ResponseEntity<?> updateHotel(@Valid @RequestBody HotelDTO hotelDTO
            ,@PathVariable String id) throws Exception {
        response.clear();
        hotelService.updateHotel(id,hotelDTO);
        response.put("message","Hotel updated successfully");
        return new ResponseEntity<>(response,HttpStatus.ACCEPTED);
    }

    @DeleteMapping("/{id}")
    private ResponseEntity<?> deleteHotel(@PathVariable String id) throws Exception {
        response.clear();
        hotelService.deleteHotelById(id);
        response.put("message","Hotel deleted successfully");
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}