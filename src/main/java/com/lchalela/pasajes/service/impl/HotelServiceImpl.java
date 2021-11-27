package com.lchalela.pasajes.service.impl;

import com.lchalela.pasajes.dto.HotelDTO;
import com.lchalela.pasajes.dto.HotelResponseDTO;
import com.lchalela.pasajes.mapper.CountryMapper;
import com.lchalela.pasajes.mapper.HotelMapper;
import com.lchalela.pasajes.model.Country;
import com.lchalela.pasajes.model.Hotel;
import com.lchalela.pasajes.repository.CountryRepository;
import com.lchalela.pasajes.repository.HotelRepository;
import com.lchalela.pasajes.repository.ReservationRepository;
import com.lchalela.pasajes.service.CountryService;
import com.lchalela.pasajes.service.HotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class HotelServiceImpl implements HotelService {

    @Autowired
    private HotelRepository hotelRepository;

    @Autowired
    private HotelMapper hotelMapper;

    @Autowired
    private CountryMapper countryMapper;

    @Autowired
    private CountryService countryService;

    @Autowired
    private CountryRepository countryRepository;

    @Autowired
    private ReservationRepository reservationRepository;

    @Override
    public List<Hotel> findAllHotel() {
        List<Hotel> hotelDTOList = hotelRepository.findAll();
        if(hotelDTOList.isEmpty()){
            new Exception("List is empty");
        }
        return hotelDTOList;
    }

    @Override
    public Hotel findHotelById(String id) throws Exception {
        Long idParse = 0l;
        try{
            idParse = Long.parseLong(id);
        }catch (NumberFormatException ef){
            new NumberFormatException("Id invalid");
        }
        return hotelRepository.findById(idParse).orElseThrow(
                () -> { return new Exception("Hotel not found");}
        );
    }

    @Override
    public void saveHotel(HotelDTO hotelDTO) throws Exception {
        Hotel hotel = hotelMapper.toEntity(hotelDTO);
        Country country = countryRepository.findById(hotelDTO.getCountryId()).orElseThrow(
                ()->{ return new Exception("Country not found");}
        );
        hotel.setCountry(country);
        hotelRepository.save(hotel);
    }

    @Override
    public void updateHotel(String id, HotelDTO hotelDTO) throws Exception {
        Long idParse = 0l;
        try {
            idParse = Long.parseLong(id);
        }catch (NumberFormatException ef){
            new NumberFormatException("The id invalid format");
        }

        Hotel hotel = hotelRepository.findById(idParse).orElseThrow(
                ()-> { return new Exception("Hotel not found");}
        );

        hotelMapper.updateEntity(hotelDTO,hotel);
        Country country = null;
        if(hotel.getCountry().getId() !=null){
            country = countryService.findCountryById(
                    String.valueOf(hotel.getCountry().getId()
            ));
        }
        hotel.setCountry(country);
        hotelRepository.save(hotel);
    }

    @Transactional
    @Override
    public void deleteHotelById(String id) throws Exception {
        Long idParse = 0l;
        try {
            idParse = Long.parseLong(id);
        }catch (NumberFormatException ef){
            new NumberFormatException("Invalid format exception");
        }
        Hotel hotel = hotelRepository.findById(idParse).orElseThrow( () ->{return new Exception("Hotel not found");});
        hotel.setCountry(null);
        reservationRepository.deleteByHotelId(hotel.getId());
        hotelRepository.save(hotel);
        hotelRepository.deleteById(idParse);
    }
}