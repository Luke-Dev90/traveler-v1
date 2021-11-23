package com.lchalela.pasajes.mapper;

import com.lchalela.pasajes.dto.PassportDTO;
import com.lchalela.pasajes.model.Passport;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface PassportMapper {
    Passport toEntity(PassportDTO passportDTO);
    PassportDTO toDTO(Passport passport);
    List<PassportDTO> toListDTO(List<Passport> passports);
    Passport updatePassport(PassportDTO passportDTO,Passport passport);
}