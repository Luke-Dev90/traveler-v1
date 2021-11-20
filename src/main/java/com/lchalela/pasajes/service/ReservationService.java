package com.lchalela.pasajes.service;

import com.lchalela.pasajes.model.Reservation;

import java.util.List;

public interface ReservationService {
    List<Reservation> findAllReservation();
    List<Reservation> findByDoc(String doc);
    Reservation findReservationById(Long id);
    void saveReservation(Reservation reservation);
    void updateReservation(Long id,Reservation reservation);
    void deleteReservationById(Long id);
}