package com.spotify.service.implement;

import com.spotify.dto.RoleDTO;
import com.spotify.entity.Role;
import com.spotify.repository.RoleRepository;
import com.spotify.service.RoleService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RoleServiceImpl implements RoleService {

    private final RoleRepository roleRepository;

    @Autowired
    public RoleServiceImpl(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    @Override
    public List<Role> getAllRole() {
        return roleRepository.findAll();
    }

    @Override
    public Optional<Role> getRoleById(String roleId) {
        return roleRepository.findById(roleId);
    }

    @Override
    public Role createOrUpdate(RoleDTO roleDTO) {
        Role role = new Role();
        if(roleDTO.getRoleId()==null || roleDTO.getRoleId().isEmpty()){
            roleDTO.setRoleId(getLatestRole().getRoleId());
        }
        BeanUtils.copyProperties(roleDTO, role);
        return roleRepository.save(role);
    }

    @Override
    public void deleteRole(String roleId) {
        roleRepository.deleteById(roleId);
    }

    @Override
    public Role getLatestRole() {
        Optional<Role> latestRole = roleRepository.findTopByOrderByRoleIdDesc();
        Role role = new Role();
        if(latestRole.isPresent()){
            role.setRoleId(increaseRoleId(latestRole.get().getRoleId()));
        } else {
            role.setRoleId("R01");
        }
        return role;
    }

    private String increaseRoleId(String roleId) {
        int id = Integer.parseInt(roleId.substring(1));
        return "R" + String.format("%02d", ++id);
    }
}
