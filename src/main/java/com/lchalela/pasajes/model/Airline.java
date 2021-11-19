package com.lchalela.pasajes.model;

import javax.persistence.*;

@Entity
@Table(name="airline")
public class Airline {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
}