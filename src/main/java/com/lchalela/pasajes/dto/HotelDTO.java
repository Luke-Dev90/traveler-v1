package com.lchalela.pasajes.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class HotelDTO {
    @NotEmpty
    private String name;
    @NotEmpty
    private String address;
    @NotEmpty
    private String street;
    @NotNull
    private Integer capacity;
    @NotNull
    private Long countryId;
    @NotNull
    private Double amount;
}