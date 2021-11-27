package com.lchalela.pasajes.repository;

import com.lchalela.pasajes.dto.ReservationDTO;
import com.lchalela.pasajes.model.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReservationRepository extends JpaRepository<Reservation,Long> {

    @Query(value = "SELECT * FROM Reservation R INNER JOIN Hotel H ON R.id = H.id" +
            " INNER JOIN Passport P ON R.id = P.id",nativeQuery = true)
    List<Reservation> findAllReservation();

    @Query(value = "SELECT * FROM Reservation R INNER JOIN Hotel H ON R.id = H.id" +
            " INNER JOIN Passport P ON R.id = P.id Group By p.num_doc having =?1",nativeQuery = true)
    List<Reservation> findAllReservationByNumDoc(String doc);

    @Modifying
    @Query(value = "Delete FROM Reservation AS R WHERE R.hotel_id =?1",nativeQuery = true)
    void deleteByHotelId(Long id);
}