package com.lchalela.pasajes.mapper;

import com.lchalela.pasajes.dto.HotelDTO;
import com.lchalela.pasajes.model.Hotel;

import java.util.List;

public interface HotelMapper {
    Hotel toEntity(HotelDTO hotelDTO);
    HotelDTO toDTO(Hotel hotel);
    List<HotelDTO> toListDTO(List<Hotel> hotelList);
    Hotel updateEntity(HotelDTO hotelDTO,Hotel hotel);
}