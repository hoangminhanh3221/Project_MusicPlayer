package com.spotify.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserDTO {

    private Integer userId;

    private String userName;

    private Boolean gender;

    private LocalDate dob;

    private String country;

    private String userImage;

    private String accountId;
}
