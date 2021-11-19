package com.lchalela.pasajes.model;

import javax.persistence.*;

@Entity
@Table(name = "pais")
public class Pais {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    @OneToMany
    @JoinColumn(name = "airline_id")
    private Airline airline;
}