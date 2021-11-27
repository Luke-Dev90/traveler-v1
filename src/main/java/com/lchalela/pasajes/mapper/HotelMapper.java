package com.lchalela.pasajes.mapper;

import com.lchalela.pasajes.dto.HotelDTO;
import com.lchalela.pasajes.dto.HotelResponseDTO;
import com.lchalela.pasajes.model.Hotel;
import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

import java.util.List;
@Mapper(componentModel = "spring")
public interface HotelMapper {
    Hotel toEntity(HotelDTO hotelDTO);
    HotelDTO toDTO(Hotel hotel);
    List<HotelDTO> toListDTO(List<Hotel> hotelList);
    List<HotelResponseDTO> toListResp(List<Hotel> hotelList);
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    Hotel updateEntity(HotelDTO hotelDTO,@MappingTarget Hotel hotel);
}