package com.muhammedtopgul.accountservice.dto;

/*
 * created by Muhammed Topgul
 * on 06/06/2021
 * at 22:24
 */

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AccountDto {

    private String id;
    private String username;
    private String email;
    private String passwd;
    private String name;
    private String surname;
    private String birthDate;
    private Date createdAt;
    private Boolean isActive;
}
