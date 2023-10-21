package com.spotify.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AccountDTO {

    private Integer accountId;

    @NotEmpty(message = "{notempty.account.username}")
    private String username;

    @Email(message = "{email.account.email}")
    private String email;

    @NotEmpty(message = "{notempty.account.password}")
    @Size(max = 20, message = "{size.account.password}")
    private String password;
}
