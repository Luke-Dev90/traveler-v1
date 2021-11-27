package com.lchalela.pasajes.controller;

import com.lchalela.pasajes.dto.CountryDTO;
import com.lchalela.pasajes.service.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/country")
public class CountryController {

    @Autowired
    private CountryService countryService;

    private Map<String,Object> response = new HashMap<>();

    @GetMapping("/all")
    private ResponseEntity<?> getAllCountries(){
        response.clear();
        response.put("countries",countryService.findAllCountries());
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("/name/{name}")
    private ResponseEntity<?> getCountryByName(@PathVariable String name){
        response.clear();
        response.put("country",countryService.findByName(name));
        return new ResponseEntity<>(response,HttpStatus.OK);
    }

    @GetMapping("/{id}")
    private ResponseEntity<?> getCountryById(@PathVariable String id) throws Exception {
        response.clear();
        response.put("country",countryService.findCountryById(id));
        return new ResponseEntity<>(response,HttpStatus.OK);
    }

    @PostMapping("/new")
    private ResponseEntity<?> saveCountry(@Valid @RequestBody CountryDTO countryDTO) throws Exception {
        response.clear();
        countryService.saveCountry(countryDTO);
        response.put("message","Country saved successfully");
        return new ResponseEntity<>(response,HttpStatus.CREATED);
    }
    @PutMapping("/{id}")
    private ResponseEntity<?> updateCountry(@Valid @RequestBody CountryDTO countryDTO,
                                            @PathVariable String id) throws Exception {
        response.clear();
        countryService.updateCountry(id,countryDTO);
        response.put("message","Country update successfully");
        return new ResponseEntity<>(response,HttpStatus.ACCEPTED);
    }

    @DeleteMapping("/{id}")
    private ResponseEntity<?> deleteCountryById(@PathVariable String id) throws Exception {
        response.clear();
        countryService.deleteCountryById(id);
        response.put("message","Country deleted successfully");
        return new ResponseEntity<>(response,HttpStatus.ACCEPTED);
    }
}