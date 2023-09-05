package com.spotify.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AccountDTO {
    @NotEmpty(message = "{notempty.account.accountid}")
    private String accountId;

    @Email(message = "{email.account.email}")
    private String email;

    @NotEmpty(message = "{notempty.account.password}")
    private String password;
}
