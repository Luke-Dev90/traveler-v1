package com.lchalela.pasajes.mapper;

import com.lchalela.pasajes.dto.RoleDTO;
import com.lchalela.pasajes.model.Role;
import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

@Mapper(componentModel = "Spring")
public interface RoleMapper {
    Role toEntity(RoleDTO roleDTO);
    RoleDTO toDTO(Role role);
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    Role updateRole(RoleDTO roleDTO,@MappingTarget Role role);
}