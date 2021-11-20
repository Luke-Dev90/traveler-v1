package com.lchalela.pasajes.service;

import com.lchalela.pasajes.model.Role;

import java.util.List;

public interface RoleService {
    List<Role> findAllRole();
    Role findRoleById(Long id);
    void saveRole(Role role);
    void updateRole(Long id, Role role);
    void deleteRoleById(Long id);
}