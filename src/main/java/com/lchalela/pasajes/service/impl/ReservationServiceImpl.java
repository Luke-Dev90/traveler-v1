package com.lchalela.pasajes.service.impl;

import com.lchalela.pasajes.dto.ReservationDTO;
import com.lchalela.pasajes.mapper.HotelMapper;
import com.lchalela.pasajes.mapper.PassportMapper;
import com.lchalela.pasajes.mapper.ReservationMapper;
import com.lchalela.pasajes.model.Hotel;
import com.lchalela.pasajes.model.Passport;
import com.lchalela.pasajes.model.Reservation;
import com.lchalela.pasajes.repository.ReservationRepository;
import com.lchalela.pasajes.service.HotelService;
import com.lchalela.pasajes.service.PassportService;
import com.lchalela.pasajes.service.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReservationServiceImpl implements ReservationService {

    @Autowired
    private ReservationRepository reservationRepository;

    @Autowired
    private HotelService hotelService;

    @Autowired
    private PassportService passportService;

    @Autowired
    private ReservationMapper reservationMapper;

    @Autowired
    private PassportMapper passportMapper;

    @Autowired
    private HotelMapper hotelMapper;

    @Override
    public List<ReservationDTO> findAllReservation() {
        List<ReservationDTO> reservationDTOList = reservationMapper.toDTO(reservationRepository.findAllReservation());
        if(reservationDTOList.isEmpty()){
            new Exception("No exist reservations");
        }
        return reservationDTOList;
    }

    @Override
    public List<ReservationDTO> findByDoc(String doc) {
        List<ReservationDTO> reservationDTOList = reservationMapper.toDTO(reservationRepository.findAllReservationByNumDoc(doc));
        if(reservationDTOList.isEmpty()){
            new Exception("Not exist documentation");
        }
        return reservationDTOList;
    }

    @Override
    public ReservationDTO findReservationById(String id) throws Exception {
        Long idParse = 0l;
        try{
            idParse = Long.parseLong(id);
        }catch (NumberFormatException ef){
            new NumberFormatException("Identification is an invalid format");
        }
        return reservationMapper.toDTO(reservationRepository.findById(idParse).orElseThrow(
                ()->{return new Exception("Id not found");}
        ));
    }

    @Override
    public void saveReservation(ReservationDTO reservationDTO) throws Exception {
        Reservation reservation = reservationMapper.toEntity(reservationDTO);
        Hotel hotel = hotelMapper.toEntity(hotelService
                .findHotelById(String.valueOf(reservationDTO.getHotelId())));
        Passport passport = passportMapper.toEntity(passportService
                .findPassportById(String.valueOf(reservationDTO.getPassportId())));
        reservation.setHotel(hotel);
        reservation.setPassport(passport);
        reservation.setAmountTotal(hotel.getAmount() * reservation.getSlot());
        reservationRepository.save(reservation);
    }

    @Override
    public void updateReservation(String id, ReservationDTO reservationDTO) throws Exception {
        Reservation reservation = reservationMapper.toEntity(findReservationById(id));
        reservationMapper.updateReservation(reservationDTO,reservation);
        Hotel hotel = hotelMapper.toEntity(hotelService
                .findHotelById(String.valueOf(reservationDTO.getHotelId())));
        Passport passport = passportMapper.toEntity(passportService
                .findPassportById(String.valueOf(reservationDTO.getPassportId())));
        reservation.setHotel(hotel);
        reservation.setPassport(passport);
        reservation.setAmountTotal(hotel.getAmount() * reservation.getSlot());
        reservationRepository.save(reservation);
    }

    @Override
    public void deleteReservationById(String id) throws Exception {
        Reservation reservation = reservationMapper.toEntity(findReservationById(id));
        reservationRepository.delete(reservation);
    }
}