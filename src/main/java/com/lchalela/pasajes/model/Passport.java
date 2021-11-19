package com.lchalela.pasajes.model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="passport")
public class Passport {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String lastname;
    private String typeDoc;
    private String numDoc;
    private Date birthday;
}