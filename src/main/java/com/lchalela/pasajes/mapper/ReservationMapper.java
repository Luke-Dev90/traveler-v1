package com.lchalela.pasajes.mapper;

import com.lchalela.pasajes.dto.ReservationDTO;
import com.lchalela.pasajes.model.Reservation;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ReservationMapper {
    Reservation toEntity(ReservationDTO reservationDTO);
    ReservationDTO toDTO(Reservation reservation);
    List<ReservationDTO> toDTO(List<Reservation> reservation);
    Reservation updateReservation(ReservationDTO reservationDTO,Reservation reservation);
}