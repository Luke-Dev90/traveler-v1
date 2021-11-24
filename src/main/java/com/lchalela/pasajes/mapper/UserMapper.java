package com.lchalela.pasajes.mapper;

import com.lchalela.pasajes.dto.UserDTO;
import com.lchalela.pasajes.model.User;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper {
    User toEntity(UserDTO userDTO);
    User updateUser(UserDTO userDTO,User user);
}