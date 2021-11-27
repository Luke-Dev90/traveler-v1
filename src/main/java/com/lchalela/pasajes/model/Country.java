package com.lchalela.pasajes.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "country")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Country {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    @ManyToOne(cascade ={ CascadeType.MERGE, CascadeType.REFRESH},fetch = FetchType.LAZY)
    @JoinColumn(name = "airline_id")
    @Cascade(org.hibernate.annotations.CascadeType.SAVE_UPDATE)
    private Airline airline;
}