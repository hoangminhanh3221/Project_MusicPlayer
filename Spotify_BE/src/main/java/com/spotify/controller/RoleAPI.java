package com.spotify.controller;

import com.spotify.dto.RoleDTO;
import com.spotify.entity.Role;
import com.spotify.service.RoleService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/api/role")
public class RoleAPI {

    private final RoleService roleService;
    private final MessageSource messageSource;

    @Autowired
    public RoleAPI(RoleService roleService, MessageSource messageSource) {
        this.roleService = roleService;
        this.messageSource = messageSource;
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<Role>> getAllRole() {
        return ResponseEntity.ok(roleService.getAllRole());
    }

    @PostMapping("/create")
    public ResponseEntity<HttpStatus> createRole(@RequestBody @Valid RoleDTO roleDTO) {
        if (roleDTO != null) {
            roleService.createOrUpdate(roleDTO);
            return ResponseEntity.status(HttpStatus.CREATED).build();
        } else {
            return ResponseEntity.badRequest().build();
        }
    }

    @PutMapping("/update")
    public ResponseEntity<HttpStatus> updateRole(@RequestBody @Valid RoleDTO roleDTO) {
        Optional<Role> currentRole = roleService.getRoleById(roleDTO.getRoleId());
        if (currentRole.isPresent()) {
            roleService.createOrUpdate(roleDTO);
            return ResponseEntity.ok().build();
        } else {
            String errorMessage = messageSource.getMessage("notfound", new Object[]{"Role"},
                    LocaleContextHolder.getLocale());
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, errorMessage);
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<HttpStatus> deleteRole(@PathVariable("id") String id) {
        Optional<Role> currentRole = roleService.getRoleById(id);
        if (currentRole.isPresent()) {
            roleService.deleteRole(id);
            return ResponseEntity.ok().build();
        } else {
            String errorMessage = messageSource.getMessage("notfound", new Object[]{"Role"},
                    LocaleContextHolder.getLocale());
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, errorMessage);
        }
    }

}
