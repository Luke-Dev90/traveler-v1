package com.lchalela.pasajes.mapper;

import com.lchalela.pasajes.dto.ReservationDTO;
import com.lchalela.pasajes.model.Reservation;
import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ReservationMapper {
    Reservation toEntity(ReservationDTO reservationDTO);
    ReservationDTO toDTO(Reservation reservation);
    List<ReservationDTO> toDTO(List<Reservation> reservation);
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    Reservation updateReservation(ReservationDTO reservationDTO,@MappingTarget Reservation reservation);
}