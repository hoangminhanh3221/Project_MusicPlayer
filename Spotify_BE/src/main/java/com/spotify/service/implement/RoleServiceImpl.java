package com.spotify.service.implement;

import com.spotify.dto.RoleDTO;
import com.spotify.entity.Role;
import com.spotify.repository.RoleRepository;
import com.spotify.service.RoleService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class RoleServiceImpl implements RoleService {

    private final RoleRepository roleRepository;
    private final MessageSource messageSource;

    @Autowired
    public RoleServiceImpl(RoleRepository roleRepository, MessageSource messageSource) {
        this.roleRepository = roleRepository;
        this.messageSource = messageSource;
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
        checkDuplicateRole(roleDTO);
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

    private void checkDuplicateRole(RoleDTO roleDTO){
        /*Kiểm tra duplicate nếu thỏa 2 điều kiện sau
         * 1. Bị trùng đữ liệu với database
         * 2. mã của dữ liệu check phải khác với mã tìm đc trong database*/
        if(roleDTO.getRoleName() != null){
            Optional<Role> role = roleRepository.findByRoleName(roleDTO.getRoleName());
            if(role.isPresent() && !Objects.equals(role.get().getRoleId(), roleDTO.getRoleId())){
                String errorMessage = messageSource.getMessage("duplicate", new Object[]{"Tên Role"},
                        LocaleContextHolder.getLocale());
                throw new RuntimeException(errorMessage);
            }
        }
    }
}
