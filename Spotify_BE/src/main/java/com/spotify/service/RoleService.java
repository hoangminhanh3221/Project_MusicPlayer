package com.spotify.service;

import com.spotify.entity.Role;

import java.util.List;
import java.util.Optional;

public interface RoleService {
    List<Role> getAllRole();

    Optional<Role> getRoleById(String roleId);

    Role createRole(Role role);

    Role updateRole(Role role);

    void deleteRole(String roleId);
}
