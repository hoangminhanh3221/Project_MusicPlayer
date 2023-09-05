package com.spotify.dto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RoleDTO {
    private String roleId;

    @NotEmpty(message = "{notempty.role.roleName}")
    @Pattern(regexp = "^[a-zA-Z0-9]*$", message = "{pattern.role.roleName}")
    private String roleName;
}
