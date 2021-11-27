package com.lchalela.pasajes.mapper;

import com.lchalela.pasajes.dto.PassportDTO;
import com.lchalela.pasajes.model.Passport;
import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

import java.util.List;

@Mapper(componentModel = "spring")
public interface PassportMapper {
    Passport toEntity(PassportDTO passportDTO);
    PassportDTO toDTO(Passport passport);
    List<PassportDTO> toListDTO(List<Passport> passports);
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    Passport updatePassport(PassportDTO passportDTO,@MappingTarget Passport passport);
}