package com.spotify.dto;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserDTO {

    private Integer userId;

    @NotEmpty(message = "{notempty.user.userName}")
    @Pattern(regexp = "^[a-zA-Z0-9]*$", message = "{pattern.user.userName}")
    private String userName;

    @NotNull(message = "{notnull.gender}")
    private Boolean gender;

    @Past(message = "{past.user.dob}")
    @NotEmpty(message = "{notempty.user.dob}")
    private LocalDate dob;

    @NotNull(message = "{notnull.country}")
    private String country;

    @NotEmpty(message = "{notempty.user.userImage}")
    private String userImage;

    private String accountId;
}
