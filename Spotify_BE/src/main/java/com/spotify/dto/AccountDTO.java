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
    @NotEmpty(message = "AccountId not null!")
    private String accountId;

    @Email(message = "Email not null")
    private String email;

    @NotEmpty(message = "Password not null!")
    private String password;

}
