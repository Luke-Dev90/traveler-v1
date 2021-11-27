package com.lchalela.pasajes.service;

import com.lchalela.pasajes.dto.HotelDTO;
import com.lchalela.pasajes.dto.HotelResponseDTO;
import com.lchalela.pasajes.model.Hotel;

import java.util.List;

public interface HotelService {
    List<Hotel> findAllHotel();
    Hotel findHotelById(String id) throws Exception;
    void saveHotel(HotelDTO hotelDTO) throws Exception;
    void updateHotel(String id,HotelDTO hotel) throws Exception;
    void deleteHotelById(String id) throws Exception;
}