package com.lchalela.pasajes.service;

import com.lchalela.pasajes.dto.ReservationDTO;

import java.util.List;

public interface ReservationService {
    List<ReservationDTO> findAllReservation();
    List<ReservationDTO> findByDoc(String doc);
    ReservationDTO findReservationById(String id) throws Exception;
    void saveReservation(ReservationDTO reservationDTO) throws Exception;
    void updateReservation(String id,ReservationDTO reservationDTO) throws Exception;
    void deleteReservationById(String id) throws Exception;
}