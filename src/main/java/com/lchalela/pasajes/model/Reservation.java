package com.lchalela.pasajes.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;
@Entity
@Table(name = "reservation")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Reservation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @OneToMany
    @JoinColumn(name = "hotel_id")
    private Hotel hotel;
    @OneToMany
    @JoinColumn(name = "passport_id")
    private Passport passport;
    private Date embark;
    private Integer slot;
    private Double amountTotal;
}