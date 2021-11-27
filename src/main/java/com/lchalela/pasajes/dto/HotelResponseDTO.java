package com.lchalela.pasajes.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.lchalela.pasajes.model.Country;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class HotelResponseDTO implements Serializable {
    private String name;
    private String address;
    private String street;
    private Integer capacity;
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private Country country;
    private Double amount;
}