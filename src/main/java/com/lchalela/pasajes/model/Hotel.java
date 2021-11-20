package com.lchalela.pasajes.model;

import javax.persistence.*;

@Entity
@Table(name = "hotel")
public class Hotel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String address;
    private String Street;
    private Integer capacity;
    @OneToOne
    @JoinColumn(name = "country_id")
    private Country country;
    private Double amount;
}