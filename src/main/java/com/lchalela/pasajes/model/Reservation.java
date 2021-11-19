package com.lchalela.pasajes.model;

import javax.persistence.*;
import java.util.Date;
@Entity
@Table(name = "reservation")
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