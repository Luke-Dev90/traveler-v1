package com.lchalela.pasajes.service;

import com.lchalela.pasajes.dto.HotelDTO;
import com.lchalela.pasajes.model.Hotel;

import java.util.List;

public interface HotelService {
    List<HotelDTO> findAllHotel();
    HotelDTO findHotelById(String id) throws Exception;
    void saveHotel(HotelDTO hotelDTO);
    void updateHotel(String id,HotelDTO hotel) throws Exception;
    void deleteHotelById(String id) throws Exception;
}