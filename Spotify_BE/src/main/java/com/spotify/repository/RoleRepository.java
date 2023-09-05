package com.spotify.repository;

import com.spotify.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RoleRepository extends JpaRepository<Role, String> {
    Optional<Role> findTopByOrderByRoleIdDesc();
}
