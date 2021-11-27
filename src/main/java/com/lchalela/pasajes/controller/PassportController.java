package com.lchalela.pasajes.controller;

import com.lchalela.pasajes.dto.PassportDTO;
import com.lchalela.pasajes.service.PassportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/passport")
public class PassportController {
    @Autowired
    private PassportService passportService;

    private Map<String,Object> response = new HashMap<>();

    @GetMapping("/all")
    private ResponseEntity<?> getAllPassport(){
        response.clear();
        response.put("passports",passportService.findAllPassport());
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    private ResponseEntity<?> getPassportById(@PathVariable String id) throws Exception {
        response.clear();
        response.put("passport",passportService.findPassportById(id));
        return new ResponseEntity<>(response,HttpStatus.OK);
    }

    @PostMapping("/save")
    private ResponseEntity<?> savePassport(@Valid @RequestBody PassportDTO passportDTO){
        response.clear();
        passportService.savePassport(passportDTO);
        response.put("message","Created passport successfully");
        return new ResponseEntity<>(response,HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    private ResponseEntity<?> updatePassport(@Valid @RequestBody PassportDTO passportDTO, @PathVariable String id) throws Exception {
        response.clear();
        passportService.updatePassport(id,passportDTO);
        response.put("message","Passport updated Successfully");
        return new ResponseEntity<>(response,HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    private ResponseEntity<?> deletePassport(@PathVariable String id) throws Exception {
        response.clear();
        passportService.deletePassportById(id);
        response.put("message","Passport deleted successfully");
        return new ResponseEntity<>(response, HttpStatus.ACCEPTED);
    }
}