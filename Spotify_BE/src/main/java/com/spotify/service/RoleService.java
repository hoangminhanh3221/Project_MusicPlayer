package com.spotify.service;

import com.spotify.dto.RoleDTO;
import com.spotify.entity.Role;

import java.util.List;
import java.util.Optional;

public interface RoleService {
    List<Role> getAllRole();
    Optional<Role> getRoleById(String roleId);
    Role createOrUpdate(RoleDTO roleDTO);
    void deleteRole(String roleId);
    Role getLatestRole();
}
