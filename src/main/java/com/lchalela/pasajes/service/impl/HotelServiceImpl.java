package com.lchalela.pasajes.service.impl;

import com.lchalela.pasajes.dto.HotelDTO;
import com.lchalela.pasajes.mapper.CountryMapper;
import com.lchalela.pasajes.mapper.HotelMapper;
import com.lchalela.pasajes.model.Country;
import com.lchalela.pasajes.model.Hotel;
import com.lchalela.pasajes.repository.HotelRepository;
import com.lchalela.pasajes.service.CountryService;
import com.lchalela.pasajes.service.HotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

    @Override
    public List<HotelDTO> findAllHotel() {
        List<HotelDTO> hotelDTOList = hotelMapper.toListDTO(hotelRepository.findAll());
        if(hotelDTOList.isEmpty()){
            new Exception("List is empty");
        }
        return hotelDTOList;
    }

    @Override
    public HotelDTO findHotelById(String id) throws Exception {
        Long idParse = 0l;
        try{
            idParse = Long.parseLong(id);
        }catch (NumberFormatException ef){
            new NumberFormatException("Id invalid");
        }
        HotelDTO hotel = hotelMapper.toDTO(hotelRepository.findById(idParse).orElseThrow(
                () -> { return new Exception("Hotel not found");}
        ));
        return hotel;
    }

    @Override
    public void saveHotel(HotelDTO hotelDTO) {
        hotelRepository.save( hotelMapper.toEntity(hotelDTO));
    }

    @Override
    public void updateHotel(String id, HotelDTO hotelDTO) throws Exception {
        Hotel hotel = hotelMapper.toEntity(findHotelById(id));
        hotelMapper.updateEntity(hotelDTO,hotel);
        Country country = null;
        if(hotel.getCountry().getId() !=null){
            country = countryMapper.toEntity( countryService.findCountryById(
                    String.valueOf(hotel.getCountry().getId())
            ));
        }
        hotel.setCountry(country);
        hotelRepository.save(hotel);
    }

    @Override
    public void deleteHotelById(String id) throws Exception {
        Hotel hotel = hotelMapper.toEntity(findHotelById(id));
        hotelRepository.delete(hotel);
    }
}