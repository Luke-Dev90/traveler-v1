package com.lchalela.pasajes.mapper;

import com.lchalela.pasajes.dto.RoleDTO;
import com.lchalela.pasajes.model.Role;
import org.mapstruct.Mapper;

@Mapper(componentModel = "Spring")
public interface RoleMapper {
    Role toEntity(RoleDTO roleDTO);
    RoleDTO toDTO(Role role);
    Role updateRole(RoleDTO roleDTO,Role role);
}