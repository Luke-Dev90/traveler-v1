package com.lchalela.pasajes.controller;

import com.lchalela.pasajes.dto.ReservationDTO;
import com.lchalela.pasajes.service.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/reservation")
public class ReservationController {

    @Autowired
    private ReservationService reservationService;

    private Map<String,Object> response = new HashMap<>();

    @GetMapping("/all")
    private ResponseEntity<?> getAllReservation(){
        response.clear();
        response.put("reservations",reservationService.findAllReservation());
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("/document/{doc}")
    private ResponseEntity<?> getReservationByDoc(@PathVariable String doc){
        response.clear();
        response.put("reservations",reservationService.findByDoc(doc));
        return new ResponseEntity<>(response,HttpStatus.OK);
    }

    @GetMapping("/{id}")
    private ResponseEntity<?> getReservationById(@PathVariable String id) throws Exception {
        response.clear();
        response.put("reservation",reservationService.findReservationById(id));
        return new ResponseEntity<>(response,HttpStatus.OK);
    }

    @PostMapping("/save")
    private ResponseEntity<?> saveReservation(@Valid @RequestBody ReservationDTO reservationDTO) throws Exception {
        response.clear();
        reservationService.saveReservation(reservationDTO);
        response.put("message","Reservation created successfully");
        return new ResponseEntity<>(response,HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    private ResponseEntity<?> updateReservation(@Valid @RequestBody ReservationDTO reservationDTO,
                                                @PathVariable String id) throws Exception {
        response.clear();
        reservationService.updateReservation(id,reservationDTO);
        response.put("message","Reservation updated successfully");
        return new ResponseEntity<>(response,HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    private ResponseEntity<?> deleteReservationById(@PathVariable String id) throws Exception {
        response.clear();
        reservationService.deleteReservationById(id);
        response.put("message","Reservation deleted successfully");
        return new ResponseEntity<>(response,HttpStatus.ACCEPTED);
    }
}