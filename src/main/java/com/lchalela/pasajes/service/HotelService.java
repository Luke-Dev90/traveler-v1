package com.lchalela.pasajes.service;

import com.lchalela.pasajes.model.Hotel;

import java.util.List;

public interface HotelService {
    List<Hotel> findAllHotel();
    Hotel findHotelById(Long id);
    void saveHotel(Hotel hotel);
    void updateHotel(Long id,Hotel hotel);
    void deleteHotelById(Long id);
}