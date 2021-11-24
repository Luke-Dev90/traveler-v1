package com.lchalela.pasajes.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CountryDTO {
    @NotEmpty
    private String name;
    @NotNull
    private Long airlineId;
}
