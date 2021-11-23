package com.lchalela.pasajes.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ReservationDTO {
    @NotNull
    private Long hotelId;
    @NotNull
    private Long passportId;
    @NotNull
    private Date embark;
    @NotNull
    private Integer slot;
}