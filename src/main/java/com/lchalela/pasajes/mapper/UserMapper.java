package com.lchalela.pasajes.mapper;

import com.lchalela.pasajes.dto.UserDTO;
import com.lchalela.pasajes.model.User;
import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

@Mapper(componentModel = "spring")
public interface UserMapper {
    User toEntity(UserDTO userDTO);
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    User updateUser(UserDTO userDTO,@MappingTarget User user);
}